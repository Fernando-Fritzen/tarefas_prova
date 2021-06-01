package com.example.tarefas.services;

import com.example.tarefas.entities.Cliente;
import com.example.tarefas.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente findById(Long id) {
        Optional<Cliente> obj = repository.findById(id);
        return obj.get();
    }

    public Cliente insert(Cliente cliente) {
        return repository.save(cliente);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Cliente update(Long id, Cliente obj) {
        Cliente entity = repository.getOne(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Cliente entity, Cliente obj) {
        entity.setNome(obj.getNome());
    }
}
