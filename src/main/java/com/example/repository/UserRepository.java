package com.example.repository;

import com.example.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository  extends JpaRepository<User,String> {
    User findByEmail(String email);

    List<User> findByNameLike(String name);
}
