package com.example.taskmanagement;

import androidx.annotation.Nullable;

public class PasswordException extends Exception {

    @Nullable
    @Override
    public String getMessage() {
        return "Invalid Password";
    }
}