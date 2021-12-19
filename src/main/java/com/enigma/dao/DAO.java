package com.enigma.dao;

import java.util.List;

public interface DAO<T, ID> {

    T getById(ID id);

    List<T> findAll();

    void save(T t);

    void update(T t);

    void deleteById(ID id);
}
