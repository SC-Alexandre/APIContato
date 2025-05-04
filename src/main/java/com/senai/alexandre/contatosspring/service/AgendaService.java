package com.senai.alexandre.contatosspring.service;

import com.senai.alexandre.contatosspring.entity.Agenda;
import com.senai.alexandre.contatosspring.entity.Contato;
import com.senai.alexandre.contatosspring.entity.StatusAgendamento;
import com.senai.alexandre.contatosspring.repository.AgendaRepository;
import com.senai.alexandre.contatosspring.repository.ContatoRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AgendaService {
    
    @Autowired
    private AgendaRepository agendaRepository;
    @Autowired
    private ContatoRepository contatoRepository;

    public List<Agenda> listarAgendas() {
        return this.agendaRepository.findAll();
    }

    public Agenda findByID(Integer id) {
        return this.agendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado com o ID: " + id));
    }

    public List<Agenda> findByStatus(StatusAgendamento status) {
        return agendaRepository.findByStatus(status);
    }

    public Agenda save(Agenda agenda) {
        if (agenda.getContatos() != null && agenda.getDataHora() != null) {
            List<Integer> idsContatos = agenda.getContatos().stream()
                    .map(Contato::getId)
                    .toList();

            LocalDateTime inicio = agenda.getDataHora().minusHours(1);
            LocalDateTime fim = agenda.getDataHora().plusHours(1);

            List<Agenda> conflitos = agendaRepository.findConflitosAgendamento(idsContatos, inicio, fim);

            if (!conflitos.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Um ou mais contatos já possuem agendamentos nesse intervalo de 1 hora.");
            }

            List<Contato> contatos = contatoRepository.findAllById(idsContatos);
            agenda.setContatos(contatos);
        }

        return this.agendaRepository.save(agenda);
    }


    public Agenda update(Agenda agenda) {
        if (!agendaRepository.existsById(agenda.getId())) {
            throw new RuntimeException("Agendamento não encontrado para edição com o ID: " + agenda.getId());
        }

        if (agenda.getContatos() != null && agenda.getDataHora() != null) {
            List<Integer> idsContatos = agenda.getContatos().stream()
                    .map(Contato::getId)
                    .toList();

            LocalDateTime inicio = agenda.getDataHora().minusHours(1);
            LocalDateTime fim = agenda.getDataHora().plusHours(1);

            List<Agenda> conflitos = agendaRepository.findConflitosAgendamento(idsContatos, inicio, fim).stream()
                    .filter(a -> !a.getId().equals(agenda.getId())) // ignorar o próprio agendamento
                    .toList();

            if (!conflitos.isEmpty()) {
                throw new RuntimeException("Um ou mais contatos já possuem agendamentos nesse intervalo de 1 hora.");
            }

            List<Contato> contatos = contatoRepository.findAllById(idsContatos);
            agenda.setContatos(contatos);
        }

        return this.agendaRepository.save(agenda);
    }

    public void delete(Integer id) {
        if (!this.agendaRepository.existsById(id)) {
            throw new RuntimeException("Agendamento não encontrado para exclusão com o ID: " + id);
        }
        this.agendaRepository.deleteById(id);
    }
}
