package com.home.testspring.controllers;

import com.home.testspring.beans.Post;
import com.home.testspring.repositories.Posts;
import com.home.testspring.repositories.Users;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("post")
public class PostController {
    @Autowired
    private Posts posts;
    @Autowired
    private Users users;

    @RequestMapping(method = RequestMethod.GET)
    public String getPosts(Model model) {
        model.addAttribute("posts", posts.getAll());
        return "post/list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getPost(@PathVariable("id") Integer postId, Model model) throws IllegalArgumentException {
        Post post = posts.getPost(postId);
        if (post == null) {
            throw new IllegalArgumentException("Post #" + postId + " not found.");
        }
        model.addAttribute("post", post);
        return "post/post";
    }

    @RequestMapping(method = RequestMethod.POST)
    @Transactional
    public String newPost(Post post) {
        post.setAuthor(users.getUserByName("admin"));
        posts.add(post);
        return "redirect:/post";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @Transactional
    public String edit(@PathVariable("id") Integer postId, @RequestParam Map<String,String> postData) throws IllegalArgumentException {
        Post post = posts.getPost(postId);
        if (post == null) {
            throw new IllegalArgumentException("Post #" + postId + " not found.");
        }
        postData.remove("_method");
        BeanWrapperImpl postBeanWrapper = new BeanWrapperImpl(post);
        postBeanWrapper.setPropertyValues(postData);
        return "redirect:/post";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @Transactional
    public String delete(Post post) throws IllegalArgumentException  {
        Post postObject = posts.getPost(post.getId());
        if (postObject == null) {
            throw new IllegalArgumentException("Post #" + post.getId() + " not found.");
        }
        posts.remove(postObject);
        return "redirect:/post";
    }
}
