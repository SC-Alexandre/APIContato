package com.senai.alexandre.contatosspring.controller;

import com.senai.alexandre.contatosspring.entity.Contato;
import com.senai.alexandre.contatosspring.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/contatos")
@CrossOrigin("*")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @GetMapping
    public List<Contato> getAllContatos() {
        return contatoService.findAll();
    }

    @PostMapping
    public Contato saveContato(@RequestBody Contato contato) {
        return contatoService.save(contato);
    }

    @PutMapping
    public Contato updateContato(@RequestBody Contato contato) {
        return contatoService.update(contato);
    }

    @DeleteMapping("/{id}")
    public void deleteContato(@PathVariable Integer id) {
        this.contatoService.delete(id);
    }
    
    @GetMapping("/grupo/{grupoId}")
    public List<Contato> listarContatosPorGrupo(@PathVariable int grupoId) {
        return contatoService.listarContatosPorGrupo(grupoId);
    }

    @PatchMapping("/{id}/favorito")
    public ResponseEntity<Void> atualizarFavorito(@PathVariable int id, @RequestBody Map<String, Boolean> payload) {
        boolean favorito = payload.get("favorito");
        contatoService.atualizarFavorito(id, favorito);
        return ResponseEntity.noContent().build();
    }
}
