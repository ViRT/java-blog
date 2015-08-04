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
    private EntityManager entityManager;

    public void addUser(User user) {
        entityManager.persist(user);
    }

    public void editUser(User user) {
        entityManager.merge(user);
    }

    public List<User> getAll() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public User getUserById(Integer userId) {
        return entityManager.find(User.class, userId);
    }

    public User getUserByName(String userName) {
        return entityManager.createQuery("SELECT u FROM User u WHERE name=:username", User.class)
                .setParameter("username", userName)
                .setMaxResults(1)
                .getSingleResult();
    }
}
