package com.example.demo.repository;

import com.example.demo.model.Picture;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public interface PictureRepository extends JpaRepository<Picture, Long> {
    public List<Picture> findByUsername(String username);
    //新加函数
    public List<Picture> findByState(int state);
}
