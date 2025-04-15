package com.senai.alexandre.contatosspring.controller;

import com.senai.alexandre.contatosspring.model.Contato;
import com.senai.alexandre.contatosspring.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @GetMapping
    public List<Contato> getAllPacientes() {
        return contatoService.findAll();
    }

    @PostMapping
    public Contato savePaciente(@RequestBody Contato contato) {
        return contatoService.save(contato);
    }

    @PutMapping
    public Contato updatePaciente(@RequestBody Contato contato) {
        return contatoService.update(contato);
    }

    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable Integer id) {
        this.contatoService.delete(id);
    }
}
