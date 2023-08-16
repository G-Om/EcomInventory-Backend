package com.ecominventory.root.services.interfaces;

import java.util.List;

public interface BaseService <T>{

    T create(T entity);
    T findById(Long id);
    T update(T entity);
    void delete(Long id);
    List<T> findAll();
}
