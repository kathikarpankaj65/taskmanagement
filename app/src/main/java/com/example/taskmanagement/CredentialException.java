package com.example.taskmanagement;

import androidx.annotation.Nullable;

public class CredentialException extends Exception {

    @Nullable
    @Override
    public String getMessage() {
        return "Credential Not Match";
    }
}