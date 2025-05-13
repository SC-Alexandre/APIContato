package com.senai.alexandre.contatosspring.entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "contato")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 100)
    private String name;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "telefone", nullable = false, length = 11)
    private String phone;

    @Column(name = "favorito")
    private Boolean favorito;

    @ManyToMany
    @JoinTable(
            name = "contato_grupo",
            joinColumns = @JoinColumn(name = "contato_id"),
            inverseJoinColumns = @JoinColumn(name = "grupo_id")
    )
    private List<Grupo> grupos;

    public Contato() {
    }

    public Contato(Integer id, String name, String email, String phone, Boolean favorito, List<Grupo> grupos) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.favorito = favorito;
        this.grupos = grupos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(Boolean favorite) {
        this.favorito = favorite;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }


}
