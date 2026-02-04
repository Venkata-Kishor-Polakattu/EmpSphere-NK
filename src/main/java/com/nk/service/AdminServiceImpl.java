package com.nk.service;

import com.nk.beans.Department;
import com.nk.beans.Employee;
import com.nk.dto.DepartmentRequestDto;
import com.nk.dto.DepartmentResponseDto;
import com.nk.exception.DepartmentNotFoundException;
import com.nk.exception.EmployeeNotFoundException;
import com.nk.mapper.DepartmentMapper;
import com.nk.repository.DepartmentRepository;
import com.nk.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminServices{

    private final DepartmentRepository repo;
    private final EmployeeRepository employeeRepository;


    @Transactional
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

    @Transactional
    @Override
    public DepartmentResponseDto updateDepartment(DepartmentResponseDto department) {
        return null;
    }

    @Transactional
    @Override
    public String deleteDepartment(String deptCode) {
      Department dept=  repo.getDepartmentByDeptCode(deptCode)
              .orElseThrow(() -> new DepartmentNotFoundException("Department not found with : "+deptCode));
      repo.delete(dept);
      return dept.getDeptName();
    }

    @Transactional
    @Override
    public String increaseSalaryByPercentage(String empCode,Integer percentage) {
        Employee emp=employeeRepository.getEmployeeByEmpCode(empCode)
                .orElseThrow(()-> new EmployeeNotFoundException("Employee not found with : "+empCode));

        Double salary=emp.getSalary();
        salary+=(salary/100)*percentage;
        emp.setSalary(salary); // Dirty read
        //employeeRepository.save(emp); Hibernate Dirty read
        return "successfully hiked the salary for "+empCode;
    }

    @Override
    public String transferDepartment(String empCode,String deptCode){
        Department dept=repo.getDepartmentByDeptCode(deptCode)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found with : "+deptCode));
        Employee emp=employeeRepository.getEmployeeByEmpCode(empCode)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with : "+empCode));

        emp.getDepartment().setDepartmentId(dept.getDepartmentId()); // Hibernate Dirty read

        //employeeRepository.transferEmployeeToDepartment(emp.getEmpCode(),dept.getDepartmentId());
        return "successfully transferred "+empCode+" to "+dept.getDeptName();
    }

    public String generateDeptCode() {
        Long id=repo.countAll();
        return "DEPT"+(id+1);
    }
}
