package com.ocherestapi.employeemanager.services;

import com.ocherestapi.employeemanager.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    void deleteEmployee(Long id);
    List<Employee> listAllEmployees();
}
