package com.home.testspring.controllers;

import com.home.testspring.beans.Post;
import com.home.testspring.repositories.Posts;
import com.home.testspring.repositories.Users;
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
    @Secured("ROLE_USER")
    public String newPost(Post post, Principal principal) {
        post.setAuthor(users.getUserByName(principal.getName()));
        posts.add(post);
        return "redirect:/post";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @Secured("ROLE_USER")
    public String edit(@PathVariable("id") Integer postId, @RequestParam Map<String, String> postData) {
        postData.remove("_method");
        postData.remove("_csrf");
        posts.edit(postId, postData);
        return "redirect:/post";
    }

    @RequestMapping(value = "**", method = RequestMethod.DELETE)
    @Secured("ROLE_ADMIN")
    public String delete(Post post) {
        posts.remove(post);
        return "redirect:/post";
    }
}
