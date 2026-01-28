package com.nk.dto;

import com.nk.enums.EmpGender;
import com.nk.enums.EmpStatus;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class EmployeeRequestDto {
    private String empCode;
    private String firstName;
    private String lastName;
    private EmpGender gender;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String designation;
    private Double salary;
    private LocalTime joiningDate;
    private EmpStatus status;
    private String email;
    private String password;
    private AddressDto address;
    private Long deptId;
}
