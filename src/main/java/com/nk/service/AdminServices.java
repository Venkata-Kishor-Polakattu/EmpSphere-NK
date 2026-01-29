package com.nk.service;

import com.nk.dto.DepartmentRequestDto;
import com.nk.dto.DepartmentResponseDto;

public interface AdminServices {
    DepartmentResponseDto createDepartment(DepartmentRequestDto dto);
    DepartmentResponseDto getDepartmentById(Long id);
    DepartmentResponseDto getDepartmentByDeptCode(String deptCode);
    DepartmentResponseDto updateDepartment(DepartmentResponseDto department);
    void deleteDepartmentById(Long id);
}
