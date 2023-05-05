package com.taskmanager.taskmanagerapp.service;

import com.taskmanager.taskmanagerapp.exception.InvalidArgumentTypeException;
import com.taskmanager.taskmanagerapp.exception.InvalidTaskIdException;
import com.taskmanager.taskmanagerapp.model.Task;
import com.taskmanager.taskmanagerapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) throws InvalidArgumentTypeException {
        try {
            return taskRepository.save(task);
        } catch (Exception e) {
            throw new InvalidArgumentTypeException();
        }

    }
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) throws InvalidTaskIdException {
        if (!taskRepository.existsById(id)) {
            throw new InvalidTaskIdException();
        }
        return taskRepository.findById(id).get();
    }

    public Task updateTask(Long id, Task task) throws InvalidTaskIdException {
        if (!taskRepository.existsById(id)) {
            throw new InvalidTaskIdException();
        }
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) throws InvalidTaskIdException {
        if (!taskRepository.existsById(id)) {
            throw new InvalidTaskIdException();
        }
        taskRepository.deleteById(id);
    }





}
