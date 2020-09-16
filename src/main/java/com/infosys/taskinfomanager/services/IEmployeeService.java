package com.infosys.taskinfomanager.services;

import com.infosys.taskinfomanager.models.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("employee")
public interface IEmployeeService {

    Employee createEmployee(Employee employee);

    //Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer empId);

}
