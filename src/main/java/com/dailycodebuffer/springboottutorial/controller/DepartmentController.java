package com.dailycodebuffer.springboottutorial.controller;

import com.dailycodebuffer.springboottutorial.entity.Department;
import com.dailycodebuffer.springboottutorial.error.DepartmentNotFoundException;
import com.dailycodebuffer.springboottutorial.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {


    private final static Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("inside save department Controller");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList()
    {    LOGGER.info("inside fetch department list Controller");

        return departmentService.fetchDepartmentList();
    }


     @GetMapping("department/{id}")
    public Department fetchMethodById(@PathVariable("id") long Id) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(Id);
    }

    @DeleteMapping("department/{id}")
    public String deleteDepartmentById(@PathVariable("id") long Id){
        departmentService.deleteDepartmentById(Id);
        return "department deleted successfully";
    }

    @PutMapping("department/{id}")
    public Department updateDepartment(@PathVariable("id") long Id,@RequestBody Department department){
       return departmentService.updateDepartment(Id,department);
    }

    @GetMapping("departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String name){
        return departmentService.fetchDepartmentByName(name);
    }
}
