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
    public ModelAndView registerUser(@Valid User user, BindingResult bindingResult){
        ModelAndView model = new ModelAndView();
        ModelAndView model2 = new ModelAndView();
        model.setViewName("views/registerForm");
        model2.setViewName("views/success");
        /*ModelAndView modelAndView = new ModelAndView("registerForm");
        ModelAndView modelAndView2 = new ModelAndView("success");*/

        if(bindingResult.hasErrors()) {
            return model;
        }
        if(userService.isUserPresent(user.getEmail())) {
            model.addObject("exist",true);

            return model;

        }
        userService.createUser(user);

        return model2;

    }



}
