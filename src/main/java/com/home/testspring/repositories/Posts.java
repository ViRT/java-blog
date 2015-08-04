package com.home.testspring.repositories;

import com.home.testspring.beans.Post;

import java.util.List;

public interface Posts {
    void addPost(Post post);

    List<Post> getAll();

    Post getPost(Integer postId);
}
