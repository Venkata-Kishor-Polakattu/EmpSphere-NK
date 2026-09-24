package com.nk.beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Department {

    @Id
    private String departmentId;

    @NotNull
    @Column(unique = true, nullable = false)
    private String deptName;

    @NotNull
    @Column(nullable = false)
    private String location;
    private String managerName;

    @CreationTimestamp
    private LocalDate createdAt; // we should generate
    @UpdateTimestamp
    private LocalDate updatedAt; // we should generate


    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}
