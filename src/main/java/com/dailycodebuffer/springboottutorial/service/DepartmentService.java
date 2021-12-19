package com.dailycodebuffer.springboottutorial.service;

import com.dailycodebuffer.springboottutorial.entity.Department;
import com.dailycodebuffer.springboottutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

    public List<Department> fetchDepartmentList();

    public Department saveDepartment(Department department);

    public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long id);

    public Department updateDepartment(Long id ,Department department);

    public Department fetchDepartmentByName(String name);
}
