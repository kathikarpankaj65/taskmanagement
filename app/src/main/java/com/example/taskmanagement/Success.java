package com.example.taskmanagement;

public class Success<T> extends Result {
    private T t;
    Success (T t) {
        this.t=t;
    }
    public T getT() {
        return t;
    }
}