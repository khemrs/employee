package com.springproject.employee.service;

import com.springproject.employee.entity.Employees;


import java.util.List;


public interface EmployeeService {

     Employees save(Employees employees);

     List<Employees> findAll();

    Employees getEmployeeById(int id);

    void deleteEmployee(int id);


}
