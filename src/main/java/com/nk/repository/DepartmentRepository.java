package com.nk.repository;

import com.nk.beans.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findById(Long id);
    Optional<Department> getDepartmentByDeptName(String name);
    Optional<Department> getDepartmentByDeptCode(String deptCode);

    boolean existsByDeptName(String deptName);
    boolean existsByDeptCode(String deptCode);

    @Query("select count(*) from Department d")
    Long countAll();
}
