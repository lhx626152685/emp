package com.edu.mapper;

import com.edu.entity.Emp;

import java.util.List;

public interface EmpMapper {

    List<Emp> listEmp();

    List<Emp> listEmpDept();

    int saveEmp(Emp emp);

    int deleteEmpById(Integer id);

    Emp getEmpById(Integer id);

    int updateEmpById(Emp emp);

}
