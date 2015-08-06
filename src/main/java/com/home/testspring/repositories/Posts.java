package com.home.testspring.repositories;

import com.home.testspring.beans.Post;

import java.util.Map;

public interface Posts extends AbstractRepository<Post> {
    void update(Integer id, Map<String, String> data) throws IllegalArgumentException;
}
