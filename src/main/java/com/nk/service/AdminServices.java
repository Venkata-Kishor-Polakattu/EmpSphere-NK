package com.nk.service;

import com.nk.dto.DepartmentRequestDto;
import com.nk.dto.DepartmentResponseDto;

public interface AdminServices {
    DepartmentResponseDto createDepartment(DepartmentRequestDto dto);
    DepartmentResponseDto getDepartmentById(Long id);
    DepartmentResponseDto getDepartmentByDeptCode(String deptCode);
    DepartmentResponseDto updateDepartment(DepartmentResponseDto department);
    String deleteDepartment(String deptCode);

    String increaseSalaryByPercentage(String empCode,Integer percentage);
    String transferDepartment(String empCode,String deptCode);
}
