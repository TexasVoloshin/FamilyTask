package com.example.controllers;

import com.example.entities.Task;
import com.example.services.TaskService;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;


    @GetMapping("/addTask")
        public ModelAndView addTask(String email){
        ModelAndView model = new ModelAndView();
        model.addObject("task",new Task());
        model.setViewName("views/taskform");

        return model;
    }

}
