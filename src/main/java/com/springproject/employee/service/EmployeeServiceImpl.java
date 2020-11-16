package com.springproject.employee.service;

import com.springproject.employee.entity.Employees;
import com.springproject.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employees save(Employees employees) {

                return employeeRepository.save(employees);
    }

    @Override
    public List<Employees> findAll() {
                return employeeRepository.findAll();
    }

    @Override
    public Employees getEmployeeById(int id) {

        return employeeRepository.getOne(id);
    }

    @Override
    public void deleteEmployee(int id) {

       employeeRepository.deleteById(id);

    }
}
