package com.dailycodebuffer.springboottutorial.service;

import com.dailycodebuffer.springboottutorial.entity.Department;
import com.dailycodebuffer.springboottutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;




@SpringBootTest
class DepartmentServiceTest {


    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentId(1l)
                .departmentAddress("E Block")
                .departmentName("electronics")
                .departmentCode("ece")
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("electronics"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get data based on department name")
    public void wheValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName =  "electronics";
        Department found = departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());

    }


}