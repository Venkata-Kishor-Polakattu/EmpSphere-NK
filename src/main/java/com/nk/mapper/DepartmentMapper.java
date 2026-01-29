package com.nk.mapper;

import com.nk.beans.Department;
import com.nk.dto.DepartmentRequestDto;
import com.nk.dto.DepartmentResponseDto;

import java.time.LocalDate;

public class DepartmentMapper {

    // ===================== Department Mapper =====================

    // ===================== DepartmentEntity -> ResponseDto =====================
    public static DepartmentResponseDto toDepartmentResponseDto(Department department) {
        if (department == null) return null;
        DepartmentResponseDto dto = new DepartmentResponseDto();
        dto.setId(department.getDepartmentId());
        dto.setDeptCode(department.getDeptCode());
        dto.setDeptName(department.getDeptName());
        dto.setLocation(department.getLocation());
        dto.setManagerName(department.getManagerName());
        return dto;
    }

    // ===================== DepartmentRequestDto -> DepartmentEntity =====================
    public static Department toDepartment(DepartmentRequestDto dto) {
        if (dto == null) return null;
        Department department = new Department();
        department.setDeptName(dto.getDeptName());
        department.setLocation(dto.getLocation());
        department.setManagerName(dto.getManagerName());
        department.setCreatedAt(LocalDate.now());
        department.setUpdatedAt(LocalDate.now());
        return department;
    }
}
