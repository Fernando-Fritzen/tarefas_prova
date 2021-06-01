package com.example.tarefas.controllers;

import com.example.tarefas.entities.Tarefa;
import com.example.tarefas.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService service;


    @GetMapping
    public ResponseEntity<List<Tarefa>> findAll() {
        List<Tarefa> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Tarefa> findById(@PathVariable Long id) {

        Tarefa obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Tarefa> insert(@RequestBody Tarefa tarefa) {
        tarefa = service.insert(tarefa);
        return ResponseEntity.ok().body(tarefa);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Tarefa> update(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        tarefa = service.update(id, tarefa);
        return ResponseEntity.ok().body(tarefa);
    }
}
