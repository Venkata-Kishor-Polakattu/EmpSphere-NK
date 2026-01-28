package com.nk.controller;

import com.nk.beans.Employee;
import com.nk.service.EmployeeSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeSerivce  employeeSerivce;

    @Autowired
    public EmployeeController(EmployeeSerivce employeeSerivce) {
        this.employeeSerivce = employeeSerivce;
    }

    public ResponseEntity<Employee> getEmployeeById(String id){
        Employee emp=new Employee();
        return ResponseEntity.ok(emp);
    }
}
