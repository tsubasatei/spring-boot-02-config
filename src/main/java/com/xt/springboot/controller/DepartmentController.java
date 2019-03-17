package com.xt.springboot.controller;

import com.xt.springboot.beans.Departments;
import com.xt.springboot.beans.Employees;
import com.xt.springboot.mapper.DepartmentMapper;
import com.xt.springboot.mapper.Employee2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xt
 * @date 2019/3/17 - 4:04
 * @description
 */
@RestController
public class DepartmentController {

    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    Employee2Mapper employeeMapper;

    @GetMapping("/dept/{id}")
    public Departments getDeptById(@PathVariable Integer id) {
        return departmentMapper.getDeptById(id);
    }

    @GetMapping("/dept")
    public Departments saveDept(Departments department) {
        departmentMapper.insertDept(department);
       return department;
    }

    @GetMapping("/emp2/{id}")
    public Employees findEmpById(@PathVariable Integer id) {
        return employeeMapper.getEmp2ById(id);
    }
}
