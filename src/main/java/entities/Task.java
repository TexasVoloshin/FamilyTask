package entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String data;
    @NotEmpty
    private  String startTime;
    @NotEmpty
    private  String stopTime;
    @NotEmpty
    private String description;
    @ManyToOne
    @JoinColumn(name = "USER_EMAIL")
    private User user;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public Task(String data, String startTime, String stopTime, String description, User user) {
        this.data = data;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.description = description;
        this.user = user;
    }

    public Task(String data, String startTime, String stopTime, String description) {
        this.data = data;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.description = description;
    }

    public Task() {
    }
}
