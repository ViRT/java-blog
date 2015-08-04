package com.home.testspring.repositories;

import com.home.testspring.beans.Post;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class PostsImpl implements Posts {
    @PersistenceContext
    private EntityManager entityManager;

    public void addPost(Post post) {
        entityManager.persist(post);
    }

    public List<Post> getAll() {
        return entityManager.createQuery("SELECT p FROM Post p", Post.class).getResultList();
    }

    public Post getPost(Integer postId){
        return entityManager.find(Post.class, postId);
    }
}
