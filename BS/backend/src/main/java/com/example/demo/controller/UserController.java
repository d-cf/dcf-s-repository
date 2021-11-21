package com.example.demo.controller;
import com.example.demo.pojo.result;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")



public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


    @GetMapping("/users/{username}")
    public result LoginCheck(@PathVariable("username") String username) {
        User user = new User();
        user = userRepository.findByUsername(username);
        if(user == null)
            return new result("1003", null);
        return new result("20000", user);
    }

    @PostMapping("/users")
    public result RegisterCheck(@RequestBody User newuser) {
        User tmpuser = new User();
        tmpuser = userRepository.findByUsername(newuser.getUsername());
        if(tmpuser != null)
            return new result("1001", null);
        tmpuser = userRepository.findByEmailId(newuser.getEmailId());
        if(tmpuser != null)
            return new result("1002", null);
        userRepository.save(newuser);
        return new result("20000", newuser);
    }
}


