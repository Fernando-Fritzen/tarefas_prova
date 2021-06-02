package com.example.tarefas.config;

import com.example.tarefas.entities.Cliente;
import com.example.tarefas.entities.Tarefa;
import com.example.tarefas.repositories.ClienteRepository;
import com.example.tarefas.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TarefaRepository tarefaRepository;


    @Override
    public void run(String... args) throws Exception {

        Cliente c1 = new Cliente(null, "Clovis Basilio");
        Cliente c2 = new Cliente(null, "Fabio Junior");

        Tarefa t1 = new Tarefa(null, "fazer relatório", "Lançar relatório no Excel", c1);
        Tarefa t2 = new Tarefa(null, "marcar reunião", "Marcar Reunião com o Bill Gates", c2);
        Tarefa t3 = new Tarefa(null, "Comprar papel", "Comprar 10 pacotes de folha A4", c1);


        clienteRepository.saveAll(Arrays.asList(c1, c2));
        tarefaRepository.saveAll(Arrays.asList(t1, t2, t3));
    }
}
