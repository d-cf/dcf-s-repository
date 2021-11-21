package com.example.demo.model;
import javax.persistence.*;

@Entity
@Table(name = "Result")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "time")
    private String time;

    @Column(name = "path")
    private String path;

    @Column(name = "receiver")
    private String receiver;

    @Column(name = "result")
    private String result;

    public Result() {

    }

    public Result(String username, String time, String path, String receiver, String result) {
        this.username = username;
        this.time = time;
        this.path = path;
        this.receiver = receiver;
        this.result = result;
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

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
