package com.nk.controller;

import com.nk.dto.EmployeeRequestDto;
import com.nk.dto.EmployeeResponseDto;
import com.nk.dto.UpdatableEmployeeDto;
import com.nk.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/employee/api")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;


    @PostMapping("/create")
    public ResponseEntity<EmployeeResponseDto> createEmployee(
            @Valid @RequestBody EmployeeRequestDto request){
        EmployeeResponseDto response = service.createEmployee(request);

        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping("/{empCode}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeByEmpCode(@PathVariable String empCode){
        EmployeeResponseDto response = service.getEmployeeByEmpCode(empCode);
        return ResponseEntity.ok().body(response);
    }

    @PatchMapping("/update/{empCode}")
    public ResponseEntity<EmployeeResponseDto> updateEmployee(@PathVariable String empCode
            ,@Valid @RequestBody UpdatableEmployeeDto request){
        EmployeeResponseDto response=service.updateEmployee(empCode,request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteEmployee(@PathVariable String empCode){
        service.deleteEmployee(empCode);
        return ResponseEntity.ok().body("Employee has been deleted successfully");
    }

    /*
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> getById(@PathVariable Long id) {
        return employeeRepository.findById(id)
            .map(emp -> EmployeeMapper.toResponseDto(emp))
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
     */
}
