package com.senai.alexandre.contatosspring.model;
import jakarta.persistence.*;

@Entity
@Table(name = "contato")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer number;

    @Column(name = "nome", nullable = false, length = 100)
    private String name;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "telefone", nullable = false, length = 11)
    private String phone;

    public Contato() {
    }

    public Contato(Integer number, String name, String email, String phone) {
        this.number = number;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Integer getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
