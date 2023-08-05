package com.example.application.exception;

public class StudentNotFound extends Exception {
    public StudentNotFound(String error) {
        super(error);
    }
}
