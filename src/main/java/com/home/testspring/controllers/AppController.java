package com.home.testspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {
    @RequestMapping(value = {"/", "/login", "/logout"}, method = RequestMethod.GET)
    public String index() {
        return "redirect:/post";
    }
}
