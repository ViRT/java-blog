package com.home.testspring.repositories;

import com.home.testspring.beans.Post;

import java.util.Map;

public interface Posts extends AbstractRepository<Post> {
    void update(Post post) throws IllegalArgumentException;
}
