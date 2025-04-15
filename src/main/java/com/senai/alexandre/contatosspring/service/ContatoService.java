package com.senai.alexandre.contatosspring.service;
import com.senai.alexandre.contatosspring.model.Contato;
import com.senai.alexandre.contatosspring.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public Contato save(Contato contato){
        return this.contatoRepository.save(contato);
    }

    public List<Contato> findAll(){
        return contatoRepository.findAll();
    }

    public Contato update(Contato contato){
        return this.save(contato);
    }

    public void delete(Integer id){
        if (!contatoRepository.existsById(id)) {
            throw new RuntimeException("Contato não encontrado para exclusão.");
        }
        this.contatoRepository.deleteById(id);
    }
}
