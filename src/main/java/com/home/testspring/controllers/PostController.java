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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Map;

@Controller
@RequestMapping("post")
public class PostController {
    @Autowired
    private Posts posts;
    @Autowired
    private Users users;

    private static final Logger LOGGER = LoggerFactory.getLogger(PostController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String getPosts(Model model) {
        model.addAttribute("posts", posts.getAll());
        LOGGER.info("Post: Get list");
        return "post/list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getPost(@PathVariable("id") Integer postId, Model model) throws IllegalArgumentException {
        Post post = posts.get(postId);
        if (post == null) {
            throw new IllegalArgumentException("Post #" + postId + " not found.");
        }
        model.addAttribute("post", post);
        LOGGER.info("Post: get post: " + post);
        return "post/post";
    }

    @RequestMapping(method = RequestMethod.POST)
    @Secured("ROLE_USER")
    public String create(Post post, Principal principal) {
        post.setAuthor(users.getUserByName(principal.getName()));
        posts.create(post);
        LOGGER.info("Post: create post: " + post);
        return "redirect:/post";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @Secured("ROLE_USER")
    public String update(@PathVariable("id") Integer postId, @RequestParam Map<String, String> postData) {
        postData.remove("_method");
        postData.remove("_csrf");
        posts.update(postId, postData);
        LOGGER.info("Post: update post #" + postId + " data: " + postData);
        return "redirect:/post";
    }

    @RequestMapping(value = "**", method = RequestMethod.DELETE)
    @Secured("ROLE_ADMIN")
    public String delete(Post post) {
        LOGGER.info("Post: delete post #" + post.getId());
        posts.remove(post);
        return "redirect:/post";
    }
}
