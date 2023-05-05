package com.taskmanager.taskmanagerapp.exception;

public class InvalidArgumentTypeException extends Exception {
    public String toString() {
        return "Input data type of task is incorrect";
    }
}
