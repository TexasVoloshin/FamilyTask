package com.example.controllers;

import com.example.entities.Task;
import com.example.services.TaskService;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;

    ModelAndView model = new ModelAndView();

    @GetMapping("/addTask")
        public ModelAndView addTask(String email){

        model.addObject("task",new Task());
        model.setViewName("views/taskform");

        return model;
    }

    @PostMapping("/addTask")
    public ModelAndView addTask(@Valid Task task, BindingResult bindingResult, HttpSession session) {
        if(bindingResult.hasErrors()) {
            return model;
        }
        String email = (String) session.getAttribute("email");
        taskService.addTask(task, userService.findUserByEmail(email));
        model.setViewName( "redirect:/users");
        return  model;
    }

}
