package com.senai.alexandre.contatosspring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "grupo")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @ManyToMany(mappedBy = "grupos")
    @JsonIgnore
    private List<Contato> contatos;

    public Grupo() {}

    public Grupo(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Grupo(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}