package com.nk.exception;

public class InvalidEmployee extends RuntimeException {
    public InvalidEmployee(String message) {
        super(message);
    }
}
