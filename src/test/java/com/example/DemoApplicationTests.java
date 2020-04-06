package com.example;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.example.entities.Task;
import com.example.entities.User;
import com.example.services.TaskService;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;

    @Before
    public void initDb() {
        {
            User newUser = new User("testUser@mail.com", "testUser", "123456");
            userService.createUser(newUser);
        }
        {
            User newUser = new User("testAdmin@mail.com", "testAdmin", "123456");
            userService.createUser(newUser);
        }

        Task userTask = new Task("03/01/2018", "00:11", "11:00", "You need to work today");
        User user = userService.findUserByEmail("testUser@mail.com");
        taskService.addTask(userTask, user);
    }

    @Test
    public void testUser() {
        User user = userService.findUserByEmail("testUser@mail.com");
        assertNotNull(user);
        User admin = userService.findUserByEmail("testAdmin@mail.com");
        assertEquals(admin.getEmail(),"testAdmin@mail.com");
    }

    @Test
    public void testTask() {
        User user = userService.findUserByEmail("testUser@mail.com");
        List<Task> task = taskService.findUserTask(user);
        assertNotNull(task);

    }





}