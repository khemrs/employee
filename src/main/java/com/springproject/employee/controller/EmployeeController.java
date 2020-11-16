package com.springproject.employee.controller;

import com.springproject.employee.entity.Employees;
import com.springproject.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public String getEmployee(ModelMap map,
    @RequestParam(required = false, defaultValue = "N") String action,
                              @RequestParam(required = false, defaultValue = "0") int id) {
        if(action.equals("D")){
            employeeService.deleteEmployee(id);

        }
        if(action.equals("U")){
           map.put("employee",employeeService.getEmployeeById(id));

        }

        map.put("employees", employeeService.findAll());

        return "employee";

    }

    @PostMapping("/employee")
    public String saveEmployee(@ModelAttribute Employees employees){
        employeeService.save(employees);
        return "redirect:/employee";
    }
}