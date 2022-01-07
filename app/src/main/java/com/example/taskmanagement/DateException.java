package com.example.taskmanagement;

import androidx.annotation.Nullable;

public class DateException extends Exception {

    @Nullable
    @Override
    public String getMessage() {
        return "Invalid Date";
    }
}