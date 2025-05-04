package com.senai.alexandre.contatosspring.controller;
import com.senai.alexandre.contatosspring.entity.Agenda;
import com.senai.alexandre.contatosspring.entity.StatusAgendamento;
import com.senai.alexandre.contatosspring.service.AgendaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("agenda")
@CrossOrigin("*")
public class AgendaController {
    
    @Autowired
    private AgendaService agendaService;

    @GetMapping
    public List<Agenda> listar() { return agendaService.listarAgendas();}

    @GetMapping("/{id}")
    public Agenda findByID(@PathVariable int id) {return agendaService.findByID(id);}

    @GetMapping("/status/{status}")
    public List<Agenda> findByStatus(@PathVariable StatusAgendamento status) {
        return agendaService.findByStatus(status);
    }

    @PostMapping
    public Agenda save(@RequestBody Agenda agenda) { return agendaService.save(agenda);}

    @PutMapping
    public Agenda update(@RequestBody Agenda agenda) { return agendaService.update(agenda);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) { agendaService.delete(id);}

}