package com.taskmanager.taskmanagerapp.controller;

import com.taskmanager.taskmanagerapp.model.Task;
import com.taskmanager.taskmanagerapp.response.ResponseHandler;
import com.taskmanager.taskmanagerapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task-manager")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<Object> getAllTasks() {
        return ResponseHandler.generateResponse("success", HttpStatus.OK, taskService.getAllTasks());
    }

    // potential error: wrong input type
    @PostMapping("/tasks")
    public ResponseEntity<Object> createTask(@RequestBody Task task) {
        try {
            return ResponseHandler.generateResponse("success", HttpStatus.OK, taskService.createTask(task));
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.toString(), HttpStatus.BAD_GATEWAY, null);
        }
    }

    // potential error: non existent input id
    @GetMapping("/tasks/{id}")
    public ResponseEntity<Object> getTaskById(@PathVariable Long id) {
        try {
            return ResponseHandler.generateResponse("success", HttpStatus.OK, taskService.getTaskById(id));
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.toString(), HttpStatus.BAD_GATEWAY, null);
        }
    }

    // potential error: non existent input id
    @PutMapping("/tasks/{id}")
    public ResponseEntity<Object> updateTask(@PathVariable Long id, @RequestBody Task task) {
        try {
            task.setId(id);
            return ResponseHandler.generateResponse("success", HttpStatus.OK, taskService.updateTask(id, task));
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.toString(), HttpStatus.BAD_GATEWAY, null);
        }
    }

    // potential error: non existent input id
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Object> deleteTask(@PathVariable Long id) {
        try {
            taskService.deleteTask(id);
            return ResponseHandler.generateResponse("success", HttpStatus.OK, "Task deleted successfully");
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.toString(), HttpStatus.BAD_GATEWAY, null);
        }
    }

}
