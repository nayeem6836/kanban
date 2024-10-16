package com.example.kanban.service;

import com.example.kanban.model.Task;
import com.example.kanban.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTasksByStatus(String status) {
        return taskRepository.findByStatus(status);
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTaskStatus(String taskId, String newStatus) {
        Task task = taskRepository.findById(taskId).orElseThrow();
        task.setStatus(newStatus);
        return taskRepository.save(task);
    }
}
