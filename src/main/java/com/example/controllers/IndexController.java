package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {



    @GetMapping("/")
    public String showIndexPage(){
        ModelAndView modelAndView = new ModelAndView("index");
        return "index";
    }
}
