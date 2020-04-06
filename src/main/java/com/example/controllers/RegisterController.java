package com.example.controllers;

import com.example.entities.User;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;



@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerForm(Model model) {

        model.addAttribute("user", new User());
        return "views/registerForm";
    }


    @PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult bindingResult, Model model) {
        ModelAndView modelAndView = new ModelAndView("registerForm");
        ModelAndView modelAndView2 = new ModelAndView("success");

        if(bindingResult.hasErrors()) {
            return "views/registerForm";
        }
        if(userService.isUserPresent(user.getEmail())) {
            model.addAttribute("exist",true);

            return "views/registerForm";

        }
        userService.createUser(user);

        return "views/success";

    }




}
