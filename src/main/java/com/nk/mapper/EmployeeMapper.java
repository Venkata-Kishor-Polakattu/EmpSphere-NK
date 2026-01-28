package com.nk.mapper;

import com.nk.beans.Employee;
import com.nk.dto.EmployeeResponseDto;

public class EmployeeMapper {

    // ===================== Employee -> EmployeeResponseDto =====================
    public static EmployeeResponseDto toEmployeeResponseDto(Employee employee) {
        if (employee == null) return null;
        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
        employeeResponseDto.setId(employee.getId());
        employeeResponseDto.setFirstName(employee.getFirstName());
        employeeResponseDto.setLastName(employee.getLastName());
        employeeResponseDto.setGender(employee.getGender());
        employeeResponseDto.setPhoneNumber(employee.getPhoneNumber());
        employeeResponseDto.setDateOfBirth(employee.getDateOfBirth());
        employeeResponseDto.setDesignation(employee.getDesignation());
        employeeResponseDto.setEmail(employee.getEmail());


        return employeeResponseDto;
    }

    // ===================== Department -> DepartmentResponseDto =====================
}
