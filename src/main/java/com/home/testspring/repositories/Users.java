package com.home.testspring.repositories;

import com.home.testspring.beans.User;

import java.util.List;

public interface Users {
    void addUser(User user);
    void editUser(User user);

    List<User> getAll();

    User getUserById(Integer userId);

    User getUserByName(String userName);
}
