package com.home.testspring.repositories;

import com.home.testspring.beans.Post;

import java.util.List;
import java.util.Map;

public interface Posts {
    void add(Post post);
    void edit(Integer postId, Map<String,String> postData) throws IllegalArgumentException;

    List<Post> getAll();

    Post getPost(Integer postId);

    void remove(Post post);
}
