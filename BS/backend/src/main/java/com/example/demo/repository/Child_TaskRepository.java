package com.example.demo.repository;
import com.example.demo.model.Child_Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Child_TaskRepository extends JpaRepository<Child_Task, Long> {
    public List<Child_Task> findChild_TaskByUsernameAndTime(String username, String time);

}
