package com.home.testspring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public void hello(@RequestParam(value = "name") String name, Model model) {
        model.addAttribute("name", name);
    }
}
