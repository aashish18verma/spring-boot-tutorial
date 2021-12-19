package com.dailycodebuffer.springboottutorial.service;

import com.dailycodebuffer.springboottutorial.entity.Department;
import com.dailycodebuffer.springboottutorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.springboottutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException {
        Optional<Department> department =
        departmentRepository.findById(id);
        if(!department.isPresent())
        {
            throw new DepartmentNotFoundException("Department not available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long departmentID, Department department) {
        Department departmentFromDb = departmentRepository.findById(departmentID).get();
        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            departmentFromDb.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            departmentFromDb.setDepartmentCode(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
            departmentFromDb.setDepartmentAddress(department.getDepartmentAddress());
        }
        return departmentRepository.save(departmentFromDb);
    }

    @Override
    public Department fetchDepartmentByName(String name) {
        return departmentRepository.findByDepartmentNameIgnoreCase(name);
    }

}
