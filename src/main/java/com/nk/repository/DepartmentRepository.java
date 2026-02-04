package com.nk.repository;

import com.nk.beans.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findById(Long id);
    Optional<Department> getDepartmentByDeptName(String name);
    Optional<Department> getDepartmentByDeptCode(String deptCode);

    boolean existsByDeptName(String deptName);
    boolean existsByDeptCode(String deptCode);

    @Query("select count(*) from Department d")
    Long countAll();


    @Modifying
    @Transactional
    @Query("delete from Department d where d.deptCode=:deptCode")
    void deleteByDeptCode(String deptCode);
}
