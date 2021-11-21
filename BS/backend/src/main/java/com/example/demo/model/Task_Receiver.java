package com.example.demo.model;
import javax.persistence.*;

@Entity
@Table(name = "Task_Receiver")
public class Task_Receiver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "time")
    private String time;

    @Column(name = "receiver")
    private String receiver;

    public Task_Receiver() {

    }

    public Task_Receiver(String username, String time, String receiver) {
        this.username = username;
        this.time = time;
        this.receiver = receiver;
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

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
