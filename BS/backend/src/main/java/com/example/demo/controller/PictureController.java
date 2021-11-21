package com.example.demo.controller;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Picture;
import com.example.demo.pojo.result;
import com.example.demo.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")



public class PictureController {

    @Autowired
    private PictureRepository pictureRepository;

    @GetMapping("/pictures")
    public List<Picture> getAllPictures(){
        return pictureRepository.findAll();
    }

    @PostMapping("/pictures")
    public Picture uploadPicture(@RequestBody Picture picture) {
        return pictureRepository.save(picture);
    }

    @GetMapping("/pictures/{username}")
    public List<Picture> getPicturesByUserName(@PathVariable String username) {
        return pictureRepository.findByUsername(username);
    }

    @PutMapping("pictures/{id}")
    public ResponseEntity<Picture> updatePictureById(@PathVariable Long id, @RequestBody Picture pictureDetails) {
        Picture picture = pictureRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Picture not exist with id: " + id));
        picture.setState(pictureDetails.getState());

        Picture updatePicture = pictureRepository.save(picture);
        return ResponseEntity.ok(updatePicture);

    }

    //新加函数
    @GetMapping("pictures/state/{state}")
    public List<Picture> getPicturesByState(@PathVariable int state){
        return pictureRepository.findByState(state);
    }
}


