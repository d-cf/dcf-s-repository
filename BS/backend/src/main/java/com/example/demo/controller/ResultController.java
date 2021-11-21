package com.example.demo.controller;
import com.example.demo.model.Result;
import com.example.demo.pojo.result;
import com.example.demo.repository.ResultRepository;
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
public class ResultController {
    @Autowired
    private ResultRepository resultRepository;

    @GetMapping("/results")
    public List<Result> getAllResults(){
        return resultRepository.findAll();
    }


}
