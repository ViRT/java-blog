package com.home.testspring.repositories;

import com.home.testspring.beans.Post;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class PostsImpl implements Posts {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Post post) {
        em.persist(post);
    }

    @Override
    public void update(Integer postId, Map<String,String> postData) throws IllegalArgumentException {
        Post post = get(postId);
        if (post == null) {
            throw new IllegalArgumentException("Post #" + postId + " not found.");
        }
        BeanWrapperImpl postBeanWrapper = new BeanWrapperImpl(post);
        postBeanWrapper.setPropertyValues(postData);
        em.merge(post);
    }

    @Override
    public List<Post> getAll() {
        return em.createQuery("SELECT p FROM Post p ORDER BY p.created", Post.class)
                .getResultList();
    }

    @Override
    public Post get(Integer postId){
        return em.find(Post.class, postId);
    }

    @Override
    public void remove(Post post) {
        em.remove(em.getReference(Post.class, post.getId()));
    }
}
