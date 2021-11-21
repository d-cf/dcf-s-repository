package com.example.demo.repository;
import com.example.demo.model.Task_Receiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Task_ReceiverRepository extends JpaRepository<Task_Receiver, Long>{

}
