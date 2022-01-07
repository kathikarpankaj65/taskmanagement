package com.example.taskmanagement;

import androidx.annotation.Nullable;

public class TasksException extends Exception {

    @Nullable
    @Override
    public String getMessage() {
        return "Invalid Tasks";
    }
}