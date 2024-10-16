package com.example.kanban.controller;

import com.example.kanban.model.Task;
import com.example.kanban.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
 @RestController
@RequestMapping("/api/tasks")
 @CrossOrigin(origins = "http://localhost:3000") // Enable CORS for your React app
public class TaskController {
     @Autowired
     private TaskService taskService;

     @GetMapping
     public List<Task> getAllTasks() {
         return taskService.getAllTasks();
     }

     @GetMapping("/status/{status}")
     public List<Task> getTasksByStatus(@PathVariable String status) {
         return taskService.getTasksByStatus(status);
     }

     @PostMapping
     public Task addTask(@RequestBody Task task) {
         return taskService.addTask(task);
     }

     @PutMapping("/{taskId}")
     public Task updateTaskStatus(@PathVariable String taskId, @RequestParam String status) {
        return taskService.updateTaskStatus(taskId, status);
    
    }
}