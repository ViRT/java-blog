package com.home.testspring.repositories.impl;

import com.home.testspring.beans.User;
import com.home.testspring.repositories.Users;
import org.springframework.stereotype.Repository;

@Repository
public class UsersImpl extends AbstractRepositoryImpl<User> implements Users {
    @Override
    protected Class getEntityClass() {
        return User.class;
    }

    public User getUserByName(String name) {
        return em.createQuery("SELECT u FROM User u WHERE username=:username", User.class)
                .setParameter("username", name)
                .setMaxResults(1)
                .getSingleResult();
    }
}
