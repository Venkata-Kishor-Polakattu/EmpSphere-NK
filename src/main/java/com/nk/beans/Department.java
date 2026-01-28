package com.nk.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    @NotNull
    @Column(unique = true, nullable = false)
    private String deptCode;

    @NotNull
    @Column(unique = true, nullable = false)
    private String deptName;

    @NotNull
    @Column(nullable = false)
    private String location;
    private String managerName;

    @CreationTimestamp
    private LocalDate createdAt;
    @UpdateTimestamp
    private LocalTime updatedAt;


    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}
