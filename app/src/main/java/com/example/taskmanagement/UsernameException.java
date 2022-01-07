package com.example.taskmanagement;

import androidx.annotation.Nullable;

public class UsernameException extends Exception {

    @Nullable
    @Override
    public String getMessage() {
        return "Invalid Username";
    }
}