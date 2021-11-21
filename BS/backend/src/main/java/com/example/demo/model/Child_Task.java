package com.example.demo.model;
import javax.persistence.*;

@Entity
@Table(name = "Child_Task")
public class Child_Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "time")
    private String time;

    @Column(name = "path")
    private String path;

    public Child_Task() {

    }

    public Child_Task(String username, String time, String path) {
        super();
        this.username = username;
        this.time = time;
        this.path = path;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
