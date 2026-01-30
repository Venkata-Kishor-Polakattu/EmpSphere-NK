package com.nk.service;

import com.nk.beans.Employee;
import com.nk.dto.EmployeeRequestDto;
import com.nk.dto.EmployeeResponseDto;
import com.nk.dto.UpdatableEmployeeDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
        EmployeeResponseDto createEmployee(EmployeeRequestDto request);

        EmployeeResponseDto getEmployeeByEmpCode(String empCode);

        List<EmployeeResponseDto> getAllEmployees();

        EmployeeResponseDto updateEmployee(String empCode,UpdatableEmployeeDto request);

        void deleteEmployee(String empCode);

        EmployeeResponseDto changeEmployeeStatus(String empCode,String status);

        List<EmployeeResponseDto> getEmployeesByDepartment(Long departmentId);
}