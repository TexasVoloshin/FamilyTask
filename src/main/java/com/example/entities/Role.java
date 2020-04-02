package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;
@Entity
public class Role {
    @Id
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<User> user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public Role(String name, List<User> user) {
        this.name = name;
        this.user = user;
    }

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }
}
