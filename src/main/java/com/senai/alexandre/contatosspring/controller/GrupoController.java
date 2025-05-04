package com.senai.alexandre.contatosspring.controller;

import com.senai.alexandre.contatosspring.entity.Contato;
import com.senai.alexandre.contatosspring.entity.Grupo;
import com.senai.alexandre.contatosspring.service.ContatoService;
import com.senai.alexandre.contatosspring.service.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupos")
@CrossOrigin("*")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    @GetMapping
    public List<Grupo> getAllGrupos() {
        return grupoService.findAll();
    }

    @PostMapping
    public Grupo saveGrupo(@RequestBody Grupo grupo) {
        return grupoService.save(grupo);
    }

    @PutMapping
    public Grupo updateGrupo(@RequestBody Grupo grupo) {
        return grupoService.update(grupo);
    }

    @DeleteMapping("/{id}")
    public void deleteGrupo(@PathVariable Integer id) {
        this.grupoService.delete(id);
    }
}