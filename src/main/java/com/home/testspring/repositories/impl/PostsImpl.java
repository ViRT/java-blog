package com.home.testspring.repositories.impl;

import com.home.testspring.beans.Post;
import com.home.testspring.repositories.Posts;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Repository
public class PostsImpl extends AbstractRepositoryImpl<Post> implements Posts {
    @Override
    protected Class getEntityClass() {
        return Post.class;
    }

    @Transactional
    public void update(Integer id, Map<String,String> data) throws IllegalArgumentException {
        Post post = get(id);
        if (post == null) {
            throw new IllegalArgumentException("Post #" + id + " not found.");
        }
        BeanWrapperImpl postBeanWrapper = new BeanWrapperImpl(post);
        postBeanWrapper.setPropertyValues(data);
        em.merge(post);
    }
}
