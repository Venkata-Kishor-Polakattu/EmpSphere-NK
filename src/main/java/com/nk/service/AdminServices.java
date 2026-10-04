package com.nk.service;

import com.nk.dto.DepartmentRequestDto;
import com.nk.dto.DepartmentResponseDto;

public interface AdminServices {
    DepartmentResponseDto createDepartment(DepartmentRequestDto dto);
    DepartmentResponseDto getDepartmentById(Long id);
    DepartmentResponseDto getDepartmentByid(String id);
    DepartmentResponseDto updateDepartment(String id,DepartmentRequestDto requestDto);
    String deleteDepartment(String id)throws Exception;

    String increaseSalaryByPercentage(String empCode,Integer percentage);
    String transferDepartment(String empCode,String id);
}
