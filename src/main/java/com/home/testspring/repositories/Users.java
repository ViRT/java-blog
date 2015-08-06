package com.home.testspring.repositories;

import com.home.testspring.beans.User;

import java.util.List;

public interface Users {
    void create(User user);
    void update(User user);

    List<User> getAll();

    User getUserById(Integer userId);

    User getUserByName(String userName);
}
