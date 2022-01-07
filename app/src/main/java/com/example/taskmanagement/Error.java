package com.example.taskmanagement;

public class Error extends Result {
    private Exception exception;
    Error (Exception exception) {
        this.exception=exception;
    }

    public Exception getException() {
        return exception;
    }

}
