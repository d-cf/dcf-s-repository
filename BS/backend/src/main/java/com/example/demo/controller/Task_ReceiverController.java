package com.example.demo.controller;
import com.example.demo.model.Task_Receiver;
import com.example.demo.pojo.result;
import com.example.demo.repository.Task_ReceiverRepository;
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
public class Task_ReceiverController {

    @Autowired
    private Task_ReceiverRepository task_receiverRepository;

    @GetMapping("/task-receivers")
    public List<Task_Receiver> getAllTaskReceivers(){
        return task_receiverRepository.findAll();
    }
}
