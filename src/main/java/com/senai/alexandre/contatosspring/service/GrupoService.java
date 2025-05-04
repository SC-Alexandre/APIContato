package com.senai.alexandre.contatosspring.service;

import com.senai.alexandre.contatosspring.entity.Grupo;
import com.senai.alexandre.contatosspring.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    public Grupo save(Grupo grupo){
        return this.grupoRepository.save(grupo);
    }

    public List<Grupo> findAll(){
        return grupoRepository.findAll();
    }

    public Grupo update(Grupo grupo){
        return this.save(grupo);
    }

    public void delete(Integer id){
        if (!grupoRepository.existsById(id)) {
            throw new RuntimeException("Grupo não encontrado para exclusão.");
        }
        this.grupoRepository.deleteById(id);
    }
}