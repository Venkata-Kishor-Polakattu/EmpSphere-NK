package com.nk.exception;

public class InvalidDepartmentName extends RuntimeException {
    public InvalidDepartmentName(String message) {
        super(message);
    }
}
