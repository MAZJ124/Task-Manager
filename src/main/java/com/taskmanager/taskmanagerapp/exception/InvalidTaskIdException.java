package com.taskmanager.taskmanagerapp.exception;

public class InvalidTaskIdException extends Exception {
    public String toString() {
        return "Task with given task id does not exist";
    }
}
