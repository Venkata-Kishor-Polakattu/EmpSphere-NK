package com.nk.exception;

public class InvalidLocation extends RuntimeException {
    public InvalidLocation(String message) {
        super(message);
    }
}
