package com.senai.alexandre.contatosspring.service;
import com.senai.alexandre.contatosspring.entity.Contato;
import com.senai.alexandre.contatosspring.entity.Grupo;
import com.senai.alexandre.contatosspring.repository.ContatoRepository;
import com.senai.alexandre.contatosspring.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private GrupoRepository grupoRepository;

    public Contato save(Contato contato) {
        return this.contatoRepository.save(contato);
    }

    public List<Contato> findAll() {
        return contatoRepository.findAll();
    }

    public Contato update(Contato contato) {
        return this.save(contato);
    }

    public void delete(Integer id) {
        if (!contatoRepository.existsById(id)) {
            throw new RuntimeException("Contato não encontrado para exclusão.");
        }
        this.contatoRepository.deleteById(id);
    }

    public List<Contato> listarContatosPorGrupo(int grupoId) {
        Grupo grupo = grupoRepository.findById(grupoId)
                .orElseThrow(() -> new RuntimeException("Grupo não encontrado"));
        return grupo.getContatos();
    }
    
    //a
    
    public Contato addContatoGrupo(Contato contato) {
        if (contato.getGrupos() != null) {
            List<Grupo> grupos = grupoRepository.findAllById(
                    contato.getGrupos().stream()
                            .map(Grupo::getId)
                            .toList()
            );
            contato.setGrupos(grupos);
        }
        return contatoRepository.save(contato);
    }

    public Contato editarContato(Contato contato) {
        if (contato.getGrupos() != null) {
            List<Grupo> grupos = grupoRepository.findAllById(
                    contato.getGrupos().stream()
                            .map(Grupo::getId)
                            .toList()
            );
            contato.setGrupos(grupos);
        }
        return contatoRepository.save(contato);
    }

}
