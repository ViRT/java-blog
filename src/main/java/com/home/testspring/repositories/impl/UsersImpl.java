package com.home.testspring.repositories.impl;

import com.home.testspring.beans.User;
import com.home.testspring.repositories.Users;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class UsersImpl extends AbstractRepositoryImpl<User> implements Users {
    @PersistenceContext
    private EntityManager em;

    @Override
    protected Class getEntityClass() {
        return User.class;
    }

    public User getUserById(Integer userId) {
        return em.find(User.class, userId);
    }

    public User getUserByName(String userName) {
        return em.createQuery("SELECT u FROM User u WHERE username=:username", User.class)
                .setParameter("username", userName)
                .setMaxResults(1)
                .getSingleResult();
    }
}