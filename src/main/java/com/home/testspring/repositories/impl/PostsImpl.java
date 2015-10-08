package com.home.testspring.repositories.impl;

import com.home.testspring.beans.Post;
import com.home.testspring.repositories.Posts;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PostsImpl extends AbstractRepositoryImpl<Post> implements Posts {
    @Override
    protected Class getEntityClass() {
        return Post.class;
    }

    @Transactional
    public void update(Post post) throws IllegalArgumentException {
        em.merge(post);
    }
}
