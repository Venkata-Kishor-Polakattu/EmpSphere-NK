package com.nk.beans;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    @Column(unique = true, nullable = false)
    private String deptCode;
    @Column(unique = true, nullable = false)
    private String deptName;

    @Column(nullable = false)
    private String location;
    private String managerName;

    private LocalDate createdAt;
    private LocalTime updatedAt;


    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}
