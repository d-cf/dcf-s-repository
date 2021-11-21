package com.example.demo.model;
import javax.persistence.*;

@Entity
@Table(name = "Picture")
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "path")
    private String path;

    @Column(name = "username")
    private String username;

    @Column(name = "state")
    private int state;

    public Picture() {

    }

    public Picture(String path, String username) {
        super();
        this.path = path;
        this.username = username;
        this.state = 0;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
