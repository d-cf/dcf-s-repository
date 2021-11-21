package com.example.demo.controller;
import com.example.demo.model.Child_Task;
import com.example.demo.pojo.result;
import com.example.demo.repository.Child_TaskRepository;
import com.example.demo.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")


public class Child_TaskController {

    @Autowired
    private Child_TaskRepository child_taskRepository;

    @GetMapping("/child-tasks")
    public List<Child_Task> getAllChildTasks() {
        return child_taskRepository.findAll();
    }

    @PostMapping("/child-tasks")
    public Child_Task uploadChildTask(@RequestBody Child_Task child_task){
        return child_taskRepository.save(child_task);
    }

    @GetMapping("/child-tasks/{username}/{time}")
    public List<Child_Task> findByUsernameAndTime(@PathVariable String username, @PathVariable String time) {
        return child_taskRepository.findChild_TaskByUsernameAndTime(username, time);
    }
}
