package com.example.taskmanagement;

import androidx.annotation.Nullable;

public class TimeException extends Exception {

    @Nullable
    @Override
    public String getMessage() {
        return "Invalid Time";
    }
}