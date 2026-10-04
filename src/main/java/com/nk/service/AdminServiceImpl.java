package com.nk.service;

import com.nk.beans.Department;
import com.nk.beans.Employee;
import com.nk.dto.DepartmentRequestDto;
import com.nk.dto.DepartmentResponseDto;
import com.nk.exception.DepartmentNotFoundException;
import com.nk.exception.EmployeeNotFoundException;
import com.nk.exception.InvalidOperation;
import com.nk.mapper.DepartmentMapper;
import com.nk.repository.DepartmentRepository;
import com.nk.repository.EmployeeRepository;
import com.nk.validators.DepartmentValidators;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminServices{


    private final DepartmentRepository repo;
    private final EmployeeRepository employeeRepository;
    private final DepartmentValidators validators;


    @Transactional
    @Override
    public DepartmentResponseDto createDepartment(DepartmentRequestDto dto) {
        if (!repo.existsByDeptName(dto.getDeptName())) {
            Department department = DepartmentMapper.toDepartment(dto);
            department.setId(generateid());
            department.setCreatedAt(LocalDate.now());
            department.setUpdatedAt(LocalDate.now());
            repo.save(department);
            return  DepartmentMapper.toDepartmentResponseDto(department);
        }else {
            throw new RuntimeException("Department already exists");
        }
    }

    @Override
    public DepartmentResponseDto getDepartmentById(Long id) {
        Department department = repo.findById(id).orElseThrow(() -> new DepartmentNotFoundException("Department not found with id " + id));
        DepartmentResponseDto responseDto = DepartmentMapper.toDepartmentResponseDto(department);
        return responseDto;
    }

    @Override
    public DepartmentResponseDto getDepartmentByid(String id) {


        Department dept = repo.findById(id).
                orElseThrow(() -> new DepartmentNotFoundException("Department not found with : "+id));

        return DepartmentMapper.toDepartmentResponseDto(dept);
    }

    @Transactional
    @Override
    public DepartmentResponseDto updateDepartment(String id,DepartmentRequestDto requestDto) {
        Department department=repo.findById(id).orElseThrow(() -> new DepartmentNotFoundException("Department not found with id "+id));

        validators.validateDepartmentRequestDto(requestDto); //validate request

        department.setDeptName(requestDto.getDeptName()); // assign new values
        department.setLocation(requestDto.getLocation());
        department.setManagerName(requestDto.getManagerName());
        department.setUpdatedAt(LocalDate.now()); // dirty checking


        DepartmentResponseDto response = DepartmentMapper.toDepartmentResponseDto(department);

        return response;
    }

    @Transactional
    @Override
    public String deleteDepartment(String id)throws Exception {
      Department dept=  repo.findById(id)
              .orElseThrow(() -> new DepartmentNotFoundException("Department not found with : "+id));

        Long count = employeeRepository.countEmployeesByDepartment_Id(dept.getId());
        if (count>0){
            throw new InvalidOperation("still "+count+" employees are working in "+id+" department so you can't delete it");
        }

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

    @Transactional
    @Override
    public String transferDepartment(String empCode,String id){
        Department dept=repo.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found with : "+id));
        Employee emp=employeeRepository.getEmployeeByEmpCode(empCode)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with : "+empCode));

        emp.setDepartment(dept); // Hibernate checking

        //employeeRepository.transferEmployeeToDepartment(emp.getEmpCode(),dept.getDepartmentId());
        return "successfully transferred "+empCode+" to "+dept.getDeptName();
    }

    public String generateid() {
        Long id=repo.countAll();
        return "DEPT"+(id+1);
    }
}
