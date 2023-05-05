package com.taskmanager.taskmanagerapp.controller;

import com.taskmanager.taskmanagerapp.model.Task;
import com.taskmanager.taskmanagerapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task-manager")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return ResponseEntity.ok(taskService.updateTask(task));
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Boolean> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok(true);
    }


}
