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

    public void add(Post post) {
        entityManager.persist(post);
    }

    public void edit(Post post) {
        entityManager.merge(post);
    }

    public List<Post> getAll() {
        return entityManager.createQuery("SELECT p FROM Post p ORDER BY p.created", Post.class)
                .getResultList();
    }

    public Post getPost(Integer postId){
        return entityManager.find(Post.class, postId);
    }

    public void remove(Post post) {
        entityManager.remove(entityManager.getReference(Post.class, post.getId()));
    }
}
