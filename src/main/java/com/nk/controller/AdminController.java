package com.nk.controller;


import com.nk.dto.DepartmentRequestDto;
import com.nk.dto.DepartmentResponseDto;
import com.nk.service.AdminServices;
import jakarta.validation.Valid;
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

    @GetMapping("/{deptId}")
    public ResponseEntity<DepartmentResponseDto> getDepartment(@PathVariable String id) {
        DepartmentResponseDto response = service.getDepartmentByid(id);
        return ResponseEntity.ok().body(response);
    }

    @PatchMapping("/update/{deptId}")
    public ResponseEntity<DepartmentResponseDto> updateDepartment(@PathVariable String id, @RequestBody DepartmentRequestDto dto) {
        DepartmentResponseDto response = service.updateDepartment(id, dto);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/delete/{deptId}")
    public ResponseEntity<String>  deleteDepartment(@PathVariable String id) throws Exception {
        String s = service.deleteDepartment(id);
        return ResponseEntity.ok().body("Department "+s+" deleted Successfully ");
    }

    @PostMapping("/hike")
    public ResponseEntity<String> hikeSalary(@Valid @RequestParam String empCode,@RequestParam Integer percentage){
        String s = service.increaseSalaryByPercentage(empCode, percentage);
        return ResponseEntity.ok().body(s);
    }

    @PostMapping("/transferDepartment")
    public ResponseEntity<String> transferDepartment(@Valid @RequestParam String empCode,String id){
        String res = service.transferDepartment(empCode, id);
        return ResponseEntity.ok().body(res);
    }
}
