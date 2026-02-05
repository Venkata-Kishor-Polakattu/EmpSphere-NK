package com.nk.exception;

public class InvalidManagerNameException extends RuntimeException {
    public InvalidManagerNameException(String message) {
        super(message);
    }
}
