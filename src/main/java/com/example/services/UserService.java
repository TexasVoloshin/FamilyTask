package com.example.services;

import com.example.entities.Role;
import com.example.entities.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUser(User user){
        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = new Role("USER");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
    }


    public void createAdim(User user){
        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role userRole = new Role("ADMIN");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);
        userRepository.save(user);
    }



    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean isUserPresent(String email) {
        // TODO Auto-generated method stub
        User u=userRepository.findByEmail(email);
        if(u!=null)
            return true;

        return false;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }


    public List<User> findByName(String name) {
        return userRepository.findByNameLike("%"+name+"%");
    }
}
