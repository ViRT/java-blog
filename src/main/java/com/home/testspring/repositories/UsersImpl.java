package com.home.testspring.repositories;

import com.home.testspring.beans.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class UsersImpl implements Users {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(User user) {
        em.persist(user);
    }

    @Override
    public void update(User user) {
        em.merge(user);
    }

    @Override
    public List<User> getAll() {
        return em.createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }

    @Override
    public User getUserById(Integer userId) {
        return em.find(User.class, userId);
    }

    @Override
    public User getUserByName(String userName) {
        return em.createQuery("SELECT u FROM User u WHERE username=:username", User.class)
                .setParameter("username", userName)
                .setMaxResults(1)
                .getSingleResult();
    }
}
