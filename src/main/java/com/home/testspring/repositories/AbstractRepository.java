package com.home.testspring.repositories;

import java.util.List;

public interface AbstractRepository<T> {
    void create(T entity);

    List<T> getAll();

    T get(Integer id);

    void remove(Integer id);
}
