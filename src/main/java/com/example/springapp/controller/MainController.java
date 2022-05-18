package com.example.springapp.controller;


import com.example.springapp.task.Task;
import com.example.springapp.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/task")
public class MainController {
    private final TaskService taskService;

    @Autowired
    public MainController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> postTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@RequestBody Task task, @PathVariable Integer id) {
        try {
            return ResponseEntity.ok(taskService.updateTask(task, id));
        } catch (InstanceNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Task>> exhibitTasks() {
        return ResponseEntity.ok(taskService.exhibitTasks());
    }

}