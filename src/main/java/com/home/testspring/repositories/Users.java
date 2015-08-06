package com.home.testspring.repositories;

import com.home.testspring.beans.User;

public interface Users extends AbstractRepository<User> {
    User getUserById(Integer userId);
    User getUserByName(String userName);
}
