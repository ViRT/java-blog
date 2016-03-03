package com.home.testspring.controllers;

import com.home.testspring.beans.Post;
import com.home.testspring.repositories.Posts;
import com.home.testspring.repositories.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
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
    public String getPosts(Model model) {
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
    public String create(@Valid Post post, Principal principal) {
        post.setAuthor(users.getUserByName(principal.getName()));
        posts.create(post);
        LOGGER.info("Post: create post: " + post);
        return "redirect:/post";
    }

    @RequestMapping(value = "/{post}", method = RequestMethod.POST)
    @Secured("ROLE_USER")
    public String update(@Valid Post post) {
        posts.update(post);
        LOGGER.info("Post: update post #" + post.getId() + " post: " + post);
        return "redirect:/post";
    }

    @RequestMapping(value = "**", method = RequestMethod.DELETE)
    @Secured("ROLE_ADMIN")
    public String delete(@RequestParam("id") Integer id) {
        LOGGER.info("Post: delete post #" + id);
        posts.remove(id);
        return "redirect:/post";
    }

    @ExceptionHandler(BindException.class)
    public String validationExceptionHandler(BindException e, final HttpServletRequest request) {
        LOGGER.error("Error validation: " + e.getMessage());
        FlashMap outputFlashMap = RequestContextUtils.getOutputFlashMap(request);
        if (outputFlashMap != null){
            outputFlashMap.put("message", e.getFieldError().getDefaultMessage());
        }
        return "redirect:" + request.getHeader(HttpHeaders.REFERER);
    }
}
