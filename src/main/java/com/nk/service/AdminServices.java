package com.nk.service;

import com.nk.dto.DepartmentRequestDto;
import com.nk.dto.DepartmentResponseDto;

public interface AdminServices {
    DepartmentResponseDto createDepartment(DepartmentRequestDto dto);
    DepartmentResponseDto getDepartmentById(Long id);
    DepartmentResponseDto getDepartmentByDeptCode(String deptCode);
    DepartmentResponseDto updateDepartment(String deptCode,DepartmentRequestDto requestDto);
    String deleteDepartment(String deptCode)throws Exception;

    String increaseSalaryByPercentage(String empCode,Integer percentage);
    String transferDepartment(String empCode,String deptCode);
}
