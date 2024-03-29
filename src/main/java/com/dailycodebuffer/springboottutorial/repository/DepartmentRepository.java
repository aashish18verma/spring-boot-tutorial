package com.dailycodebuffer.springboottutorial.repository;

import com.dailycodebuffer.springboottutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Department findByDepartmentName(String name);
    Department findByDepartmentNameIgnoreCase(String name);
}
