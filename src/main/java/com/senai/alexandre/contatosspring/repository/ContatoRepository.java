package com.senai.alexandre.contatosspring.repository;
import com.senai.alexandre.contatosspring.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ContatoRepository extends JpaRepository<Contato, Integer>{
}
