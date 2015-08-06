package com.home.testspring.repositories.impl;

import com.home.testspring.repositories.AbstractRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

abstract public class AbstractRepositoryImpl<T> implements AbstractRepository<T> {
    @PersistenceContext
    protected EntityManager em;

    protected abstract Class getEntityClass();

    @Transactional
    public void create(T entity) {
        em.persist(entity);
    }

    public List<T> getAll() {
        return em.createQuery("SELECT t FROM " +  getEntityClass().getName() + " t", getEntityClass())
                .getResultList();
    }

    public T get(Integer id){
        return (T) em.find(getEntityClass(), id);
    }

    @Transactional
    public void remove(Integer id) {
        em.remove(em.getReference(getEntityClass(), id));
    }
}
