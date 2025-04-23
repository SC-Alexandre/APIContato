package com.senai.alexandre.contatosspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(title = "${info.build.name}",
                version = "${info.build.version}",
                description = "${info.app.description}",
                contact = @io.swagger.v3.oas.annotations.info.Contact(name = "Alexandre dos Santos Cunha", email = "alexandre.sc115@gmail.com")))

@SpringBootApplication
public class ContatosSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContatosSpringApplication.class, args);
    }

}
