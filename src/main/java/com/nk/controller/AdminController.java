package com.nk.controller;


import com.nk.dto.DepartmentRequestDto;
import com.nk.dto.DepartmentResponseDto;
import com.nk.service.AdminServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminServices service;


    @PostMapping("/create")
    public DepartmentResponseDto  create(@RequestBody DepartmentRequestDto dto) {
       return service.createDepartment(dto);
    }

    @GetMapping("/{deptCode}")
    public DepartmentResponseDto getDepartment(@PathVariable String deptCode) {
        DepartmentResponseDto response = service.getDepartmentByDeptCode(deptCode);
        return response;
    }
}
