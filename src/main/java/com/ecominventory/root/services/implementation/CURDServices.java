package com.ecominventory.root.services.implementation;

import com.ecominventory.root.services.interfaces.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public abstract class CURDServices<T> implements BaseService<T> {

    @Autowired
    private JpaRepository<T, Long> repository;


    @Override
    public T create(T entity) {
        return repository.save(entity);
    }

    @Override
    public T findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public T update(T entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }


    @Override
    public List<T> findAll() {
        return (List<T>) repository.findAll();
    }
}
