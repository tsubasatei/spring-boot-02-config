package com.xt.springboot.beans;

/**
 * @author xt
 * @date 2019/3/16 - 12:54
 * @description
 */
public class Departments {
    private Integer id;
    private String departmentName; //

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
