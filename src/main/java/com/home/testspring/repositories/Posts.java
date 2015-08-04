package com.home.testspring.repositories;

import com.home.testspring.beans.Post;

import java.util.List;

public interface Posts {
    void add(Post post);
    void edit(Post post);

    List<Post> getAll();

    Post getPost(Integer postId);

    void remove(Post post);
}
