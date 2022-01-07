package com.example.taskmanagement;

import androidx.annotation.Nullable;

public class ProjectException extends Exception {

    @Nullable
    @Override
    public String getMessage() {
        return "Invalid Project";
    }
}