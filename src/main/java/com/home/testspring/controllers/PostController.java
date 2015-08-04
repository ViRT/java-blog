package com.home.testspring.controllers;

import com.home.testspring.beans.Post;
import com.home.testspring.repositories.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("post")
public class PostController {
    @Autowired
    private Posts posts;

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
    public void newPost(@RequestParam("post") Post post) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("New method is not implemented");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void edit(@RequestParam("post") Post post) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Edit method is not implemented");
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestParam("post") Post post) throws UnsupportedOperationException, IllegalArgumentException {
        throw new UnsupportedOperationException("Delete method is not implemented");
    }
}
