package com.xt.springboot.mapper;

import com.xt.springboot.beans.Employees;

/**
 * @Mapper 或者 @MapperScan 将接口扫描装配到容器中
 */
public interface Employee2Mapper {

    Employees getEmp2ById(Integer id);

    void insertEmp(Employees employees);
}
