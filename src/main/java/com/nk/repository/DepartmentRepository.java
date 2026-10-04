package com.nk.repository;

import com.nk.beans.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findById(String id);
    boolean existsByDeptName(String deptName);

    @Query("select count(*) from Department d")
    Long countAll();

    void deleteById(String id);
}
