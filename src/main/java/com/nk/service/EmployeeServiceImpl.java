package com.nk.service;

import com.nk.beans.Department;
import com.nk.beans.Employee;
import com.nk.dto.EmployeeRequestDto;
import com.nk.dto.EmployeeResponseDto;
import com.nk.dto.UpdatableEmployeeDto;
import com.nk.exception.DepartmentNotFoundException;
import com.nk.exception.EmployeeNotFoundException;
import com.nk.mapper.EmployeeMapper;
import com.nk.mapper.EmployeeMapper2;
import com.nk.repository.DepartmentRepository;
import com.nk.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository  employeeRepository;
    private final EmployeeMapper2 employeeMapper2;


    @Override
    public EmployeeResponseDto createEmployee(EmployeeRequestDto request) {

        // check the dept
        Department dept = departmentRepository.findById(request.getDeptId())
                .orElseThrow(()-> new DepartmentNotFoundException("Department Does not exist"));

        // map DTO -> Entity
        Employee employee = EmployeeMapper.toEmployee(request, dept);
        employee.setEmpCode(generateEmpCode(request.getDeptId()));


        // save to DB
        Employee saved = employeeRepository.save(employee);

        //return Response
        return EmployeeMapper.toResponseDto(saved);
    }


    @Override
    public EmployeeResponseDto getEmployeeByEmpCode(String empCode) {
        Optional<Employee> empOptional = employeeRepository.getEmployeeByEmpCode(empCode);
        return empOptional.map(EmployeeMapper::toResponseDto).orElseThrow(
                ()->new  EmployeeNotFoundException("Employee Does not exist with :"+empCode)
        );
    }

    @Override
    public List<EmployeeResponseDto> getAllEmployees() {
        for (Employee employee : employeeRepository.findAll()) {
            EmployeeMapper.toResponseDto(employee);
        }
        return List.of();
    }

    @Override
    public EmployeeResponseDto updateEmployee(String empCode,UpdatableEmployeeDto request) {
        // check employee existence
        // check existing properties that are unique and can not be changed like, email, joiningDate
        Employee employee = employeeRepository.getEmployeeByEmpCode(empCode)
                .orElseThrow(()-> new EmployeeNotFoundException("Employee Does not exist with :"+empCode));

        employeeMapper2.updateEmployeeFromDto(request, employee);
        Employee saved = employeeRepository.save(employee);
        return EmployeeMapper.toResponseDto(saved);
    }

    @Override
    public void deleteEmployee(String empCode) {
       Employee emp= employeeRepository.getEmployeeByEmpCode(empCode)
               .orElseThrow(()-> new EmployeeNotFoundException("Employee Does not exist with :"+empCode));
       employeeRepository.delete(emp);
    }

    @Override
    public EmployeeResponseDto changeEmployeeStatus(Long id, String status) {
        return null;
    }

    @Override
    public List<EmployeeResponseDto> getEmployeesByDepartment(Long departmentId) {
        return List.of();
    }

    public String generateEmpCode(Long deptId){
        Long code=employeeRepository.countEmployeesByDepartment_Id(deptId)+1;
        return "EMP-"+String.format("%04d",code);
    }
}