package com.nk.repository;


import com.nk.beans.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {


    Optional<Employee> getEmployeeByEmpCode(String empCode);
    boolean existsByEmpCode(String empCode);

    @Query("select count(e) from Employee e where e.department.departmentId=:deptId")
    Long countEmployeesByDepartment_Id(@Param("deptId") Long departmentId);

    @Modifying
    @Transactional
    @Query("update Employee e set e.department.departmentId=:id where e.empCode=:empCode")
    void transferEmployeeToDepartment(String empCode, Long id);
}
