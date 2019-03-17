package com.xt.springboot.mapper;

import com.xt.springboot.beans.Departments;
import org.apache.ibatis.annotations.*;

import java.util.List;

//指定这是一个操作数据库的mapper
//@Mapper
public interface DepartmentMapper {

    @Select("select * from department")
    List<Departments> findAll();

    @Select("select * from department where id=#{id}")
    Departments getDeptById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into department(departmentName) values(#{departmentName})")
    int insertDept(Departments department);

    @Update("update department set(departmentName=#{departmentName}) where id=#{id}")
    int updateDept(Departments department);

    @Delete("delete from department where id=#{id}")
    int deleteDeptById(Integer id);
}
