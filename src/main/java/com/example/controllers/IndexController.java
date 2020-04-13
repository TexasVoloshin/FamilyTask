package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {



    @GetMapping("/")
    public ModelAndView showIndexPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }



    @GetMapping("/login")
    public ModelAndView showLoginPage(){
        ModelAndView model = new ModelAndView();
        model.setViewName("views/loginform");
        return model;
    }
}
