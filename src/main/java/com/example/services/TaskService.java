package com.example.services;

import com.example.entities.Task;
import com.example.entities.User;
import com.example.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public void addTask(Task task, User user) {
        this.taskRepository = taskRepository;
        task.setUser(user);
        taskRepository.save(task);

    }

    public List<Task> findUserTask(User user){
        return taskRepository.findByUser(user);

    }

}
