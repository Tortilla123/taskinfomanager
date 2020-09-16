package com.infosys.taskinfomanager.controllers;

import com.infosys.taskinfomanager.models.Employee;
import com.infosys.taskinfomanager.repository.EmployeeRepository;
import com.infosys.taskinfomanager.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.persistence.GeneratedValue;
import java.util.Arrays;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @Autowired
    EmployeeRepository repository;

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> findAll(){
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok().body(this.employeeService.createEmployee(employee));
    }

    @GetMapping("/addEmployee")
    public String addEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute( "employee", employee );

        return "";
    }

    @PostMapping("/addEmployee")
    public String employeeSubmit(@Validated @ModelAttribute("employee") Employee employee, BindingResult result,  Model model){
        model.addAttribute("employee", employee);
        System.out.println(result);
        System.out.println(employee.getEmpId() + " " + employee.getCid()+ " " + employee.getAccess()+ " "+ employee.getGroupId() + " " + employee.getMaintId());

        repository.save(employee);

        return "";
    }


}
