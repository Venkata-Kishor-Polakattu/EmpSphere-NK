package com.nk.dto;

import com.nk.enums.EmpGender;
import com.nk.enums.EmpStatus;

import java.time.LocalDate;

public class UpdatableEmployeeDto {
    private String firstName;
    private String lastName;
    private EmpGender gender;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String designation;
    private Double salary;
    private EmpStatus status;
    private AddressDto address;
}
