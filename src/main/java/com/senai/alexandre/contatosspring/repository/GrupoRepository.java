package com.senai.alexandre.contatosspring.repository;

import com.senai.alexandre.contatosspring.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrupoRepository extends JpaRepository<Grupo, Integer> {
}