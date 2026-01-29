package com.nk.exception;

public class EmployeeAlreadyExists extends RuntimeException {
    public EmployeeAlreadyExists(String message) {
        super(message);
    }
}
