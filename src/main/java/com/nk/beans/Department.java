package com.nk.beans;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    @Column(unique = true)
    private String deptCode;
    @Column(unique = true)
    private String deptName;

    private String location;
    private String managerName;


    private List<Employee> employees;
}
