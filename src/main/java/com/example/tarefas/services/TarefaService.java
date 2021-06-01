package com.example.tarefas.services;

import com.example.tarefas.entities.Tarefa;
import com.example.tarefas.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    public List<Tarefa> findAll() {
        return repository.findAll();
    }

    public Tarefa findById(Long id) {
        Optional<Tarefa> obj = repository.findById(id);
        return obj.get();
    }

    public Tarefa insert(Tarefa tarefa) {
        return repository.save(tarefa);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Tarefa update(Long id, Tarefa obj) {
        Tarefa entity = repository.getOne(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Tarefa entity, Tarefa obj) {
        entity.setTitulo(obj.getTitulo());
        entity.setDescricao(obj.getDescricao());
    }
}
