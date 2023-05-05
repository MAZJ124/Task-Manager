package com.taskmanager.taskmanagerapp.repository;

import com.taskmanager.taskmanagerapp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
