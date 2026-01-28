package com.nk.dto;

import com.nk.enums.EmpGender;
import com.nk.enums.EmpStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private EmpGender gender;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String designation;
    private Double salary;
    private EmpStatus status;
    private String email;
    private AddressDto address;
    private DepartmentResponseDto department;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
