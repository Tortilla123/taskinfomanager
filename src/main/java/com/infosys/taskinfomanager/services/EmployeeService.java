package com.infosys.taskinfomanager.services;

import com.infosys.taskinfomanager.exceptions.ResourceNotFound;
import com.infosys.taskinfomanager.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;

import com.infosys.taskinfomanager.models.Employee;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService implements IEmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees(){
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer empId) {
        Optional<Employee> employeeDB = this.employeeRepository.findById(empId);

        if(employeeDB.isPresent()){
            return employeeDB.get();
        }else{
            throw new ResourceNotFound("Employee not found with ID: "+ empId);
        }
    }


}
