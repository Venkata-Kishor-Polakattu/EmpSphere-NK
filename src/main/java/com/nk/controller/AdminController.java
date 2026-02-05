package com.nk.controller;


import com.nk.dto.DepartmentRequestDto;
import com.nk.dto.DepartmentResponseDto;
import com.nk.service.AdminServices;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminServices service;


    @PostMapping("/create")
    public ResponseEntity<DepartmentResponseDto>  create(@RequestBody DepartmentRequestDto dto) {
        DepartmentResponseDto department = service.createDepartment(dto);
        return ResponseEntity.ok().body(department);
    }

    @GetMapping("/{deptCode}")
    public ResponseEntity<DepartmentResponseDto> getDepartment(@PathVariable String deptCode) {
        DepartmentResponseDto response = service.getDepartmentByDeptCode(deptCode);
        return ResponseEntity.ok().body(response);
    }

    @PatchMapping("/update/{deptCode}")
    public ResponseEntity<DepartmentResponseDto> updateDepartment(@PathVariable String deptCode, @RequestBody DepartmentRequestDto dto) {
        DepartmentResponseDto response = service.updateDepartment(deptCode, dto);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/delete/{deptCode}")
    public ResponseEntity<String>  deleteDepartment(@PathVariable String deptCode) throws Exception {
        String s = service.deleteDepartment(deptCode);
        return ResponseEntity.ok().body("Department "+s+" deleted Successfully ");
    }

    @PostMapping("/hike")
    public ResponseEntity<String> hikeSalary(@Valid @RequestParam String empCode,@RequestParam Integer percentage){
        String s = service.increaseSalaryByPercentage(empCode, percentage);
        return ResponseEntity.ok().body(s);
    }

    @PostMapping("/transferDepartment")
    public ResponseEntity<String> transferDepartment(@Valid @RequestParam String empCode,String deptCode){
        String res = service.transferDepartment(empCode, deptCode);
        return ResponseEntity.ok().body(res);
    }
}
