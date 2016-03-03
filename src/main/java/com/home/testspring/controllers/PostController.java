package com.home.testspring.controllers;

import com.home.testspring.beans.Post;
import com.home.testspring.repositories.Posts;
import com.home.testspring.repositories.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("post")
public class PostController {
    @Autowired
    private Posts posts;
    @Autowired
    private Users users;

    private final Logger LOGGER = LoggerFactory.getLogger(PostController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String getPosts(Model model, Post post) {
        model.addAttribute("posts", posts.getAll());
        LOGGER.info("Post: Get list");
        return "post/list";
    }

    @RequestMapping(value = "/{post}", method = RequestMethod.GET)
    public String getPost(@PathVariable("post") Integer id, Model model) throws IllegalArgumentException {
        Post post = posts.get(id);
        if (post == null) {
            throw new IllegalArgumentException("Post #" + id + " not found.");
        }
        model.addAttribute("post", post);
        LOGGER.info("Post: get post: " + post);
        return "post/post";
    }

    @RequestMapping(method = RequestMethod.POST)
    @Secured("ROLE_USER")
    public String create(@Valid Post post, BindingResult result, Principal principal, Model model) {
        LOGGER.info("Post: create: validate post: " + result);
        if (result.hasErrors()) {
            return getPosts(model, post);
        } else {
            post.setAuthor(users.getUserByName(principal.getName()));
            posts.create(post);
            LOGGER.info("Post: create post: " + post);
        }
        return "redirect:/post";
    }

    @RequestMapping(value = "/{post}", method = RequestMethod.POST)
    @Secured("ROLE_USER")
    public String update(@Valid Post post, BindingResult result) {
        LOGGER.info("Post: update: validate post: " + result);
        if (result.hasErrors()) {
            return "post/post";
        } else {
            posts.update(post);
            LOGGER.info("Post: update post #" + post.getId() + " post: " + post);
        }
        return "redirect:/post";
    }

    @RequestMapping(value = "**", method = RequestMethod.DELETE)
    @Secured("ROLE_ADMIN")
    public String delete(@RequestParam("id") Integer id) {
        LOGGER.info("Post: delete post #" + id);
        posts.remove(id);
        return "redirect:/post";
    }
}
