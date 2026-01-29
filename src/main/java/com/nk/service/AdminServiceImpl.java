package com.nk.service;

import com.nk.beans.Department;
import com.nk.dto.DepartmentRequestDto;
import com.nk.dto.DepartmentResponseDto;
import com.nk.exception.DepartmentNotFoundException;
import com.nk.mapper.DepartmentMapper;
import com.nk.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminServices{

    private final DepartmentRepository repo;


    @Override
    public DepartmentResponseDto createDepartment(DepartmentRequestDto dto) {
        if (!repo.existsByDeptName(dto.getDeptName())) {
            Department department = DepartmentMapper.toDepartment(dto);
            department.setDeptCode(generateDeptCode());
            repo.save(department);
            return  DepartmentMapper.toDepartmentResponseDto(department);
        }else {
            throw new RuntimeException("Department already exists");
        }
    }

    @Override
    public DepartmentResponseDto getDepartmentById(Long id) {
        return null;
    }

    @Override
    public DepartmentResponseDto getDepartmentByDeptCode(String deptCode) {
        Department dept = repo.getDepartmentByDeptCode(deptCode).
                orElseThrow(() -> new DepartmentNotFoundException("Department not found with : "+deptCode));

        return DepartmentMapper.toDepartmentResponseDto(dept);
    }

    @Override
    public DepartmentResponseDto updateDepartment(DepartmentResponseDto department) {
        return null;
    }

    @Override
    public void deleteDepartmentById(Long id) {

    }

    public String generateDeptCode() {
        Long id=repo.countAll();
        return "DEPT"+id+1;
    }
}
