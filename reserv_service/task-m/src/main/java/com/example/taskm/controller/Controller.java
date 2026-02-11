package com.example.taskm.controller;

import com.example.taskm.entity.Task;
import com.example.taskm.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    private final TaskService taskService;

    public Controller(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping
    public String getTasks() {
        return taskService.IskaKotak();
    }

    @GetMapping("/tasks")
    public List<Task> getAll() {
        return taskService.getAll();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }
}
