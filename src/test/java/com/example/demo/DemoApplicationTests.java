package com.example.demo;

import com.example.entities.Task;
import com.example.entities.User;
import com.example.services.TaskService;
import com.example.services.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests<userTask, user> {

    @Autowired
    private UserService  userService;
    private TaskService taskService;
  @Before
   public void intDB(){
       User newUser = new User("newuser@mail.com", "testUser", "123456");
       userService.createUser(newUser);

       User newUser1 = new User("testadmin@mail.com", "testAdmin", "123456");
       userService.createUser(newUser1);
   }
        Task userTask = new Task ("03/04/2020", "12:00", "15:00", "Walking the dog");
        User user = new UserService.findOne("newuser@mail.com");
        taskService.addTask(userTask, user);

}
        @Test
        public void testUser(){
            User user = new UserService.findOne("newuser@mail.com");
            assertNotNull(user);
            User admin = new UserService.findOne("testamin@mail.com");
            assertEquals(admin.getEmail(),"testamin@mail.com");

        }
        @Test
        public  void testTask(){
            User user = new UserService.findOne("newuser@mail.com");
            List<Task> task = taskService.findUserTask(user);
            assertNotNull(task);

        }
}