package com.devleofulco.Properties.Value.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SistemaMensagem implements CommandLineRunner {

    @Value("${nome}")
    private String nome;
    @Value("${email}")
    private String email;
    @Value("${telefones}")
    private List<Long> telefones;

    @Override
    public void run(String... args)throws Exception{
        System.out.println("Mensagem enviada por: "+ nome + "\n E-mail: "+email +"\n Com telefone: "+ telefones);
        System.out.println("Seu cadastro foi aprovado! ");
    }
}
