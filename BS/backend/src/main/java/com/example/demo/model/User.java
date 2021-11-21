package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String username;


    @Column(name = "password")
    private String password;

    @Column(name = "emailId")
    private String emailId;

    public User(){

    }

    public User(String username,String password,String emailId){
        super();
        this.username=username;
        this.password=password;
        this.emailId=emailId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
