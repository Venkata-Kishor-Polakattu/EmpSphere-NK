package com.nk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleEmployeeNotFoundException(EmployeeNotFoundException e){
        Map<String,Object> response = new HashMap<>();
        response.put("status", HttpStatus.FOUND.value());
        response.put("message", e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleDepartmentNotFoundException(DepartmentNotFoundException e){
        Map<String,Object> response = new HashMap<>();
        response.put("status",HttpStatus.NOT_FOUND.value());
        response.put("message", e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,Object>> handleException(Exception e) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.put("message", e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
