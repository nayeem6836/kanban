package com.example.kanban.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.kanban.model.Task;

public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findByStatus(String status);
}
