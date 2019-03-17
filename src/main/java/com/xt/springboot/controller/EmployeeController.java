package com.xt.springboot.controller;

import com.xt.springboot.dao.DepartmentDao;
import com.xt.springboot.dao.EmployeeDao;
import com.xt.springboot.entities.Department;
import com.xt.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author xt
 * @date 2019/3/12 - 15:17
 * @description
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    // 查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> list = employeeDao.getAll();

        // 放在请求域
        model.addAttribute("emps", list);
        return "emp/list";
    }

    // 跳转添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";

    }

    // 添加员工信息
    // SpringMVC 自动将请求参数和入参对象的属性进行一一绑定，要求请求参数的名字和javabean入参的对象里面的属性名是一样的
    @PostMapping("/emp")
    public String addEmp(Employee employee){

        System.out.println("保存的员工信息：" + employee);
        employeeDao.save(employee);

        // redirect: 表示重定向到一个地址 /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/emps";
    }

    // 跳转修改页面, 查询当前员工，在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        Collection<Department> departments = departmentDao.getDepartments();

        model.addAttribute("depts", departments);
        model.addAttribute("emp", employee);

        // 回到修改页面（add是一个修改添加二合一的页面）
        return "emp/add";
    }

    // 员工修改
    @PutMapping("/emp")
    public String editEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    // 删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id) {
        Employee employee = employeeDao.get(id);
        if (employee != null) {
            employeeDao.delete(id);
        }
        return "redirect:/emps";
    }
}
