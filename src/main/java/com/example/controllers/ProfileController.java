package com.example.controllers;

import com.example.entities.User;
import com.example.services.TaskService;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class ProfileController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;


    @GetMapping("/profile")
    public ModelAndView showProfilePage(Principal principal){
        ModelAndView model = new ModelAndView();
        String email=principal.getName();
        User user = userService.findUserByEmail(email);
        model.addObject("task", taskService.findUserTask(user));
        model.setViewName("views/profile");
        return model;
    }
}
