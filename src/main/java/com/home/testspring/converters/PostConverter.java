package com.home.testspring.converters;

import com.home.testspring.beans.Post;
import com.home.testspring.repositories.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class PostConverter implements Converter<String, Post> {
    @Autowired
    private Posts posts;

    public Post convert(String post) {
        return posts.get(Integer.parseInt(post));
    }
}
