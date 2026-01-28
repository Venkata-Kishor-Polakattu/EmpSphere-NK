package com.nk.repository;

import com.nk.beans.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {


    Optional<Employee> getEmployeeByEmpCode(String empCode);
    boolean existsByEmpCode(String empCode);

}
