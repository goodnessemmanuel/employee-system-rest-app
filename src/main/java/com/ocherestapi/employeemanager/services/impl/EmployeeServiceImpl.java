package com.ocherestapi.employeemanager.services.impl;

import com.ocherestapi.employeemanager.exception.EmployeeNotFoundException;
import com.ocherestapi.employeemanager.model.Employee;
import com.ocherestapi.employeemanager.repository.EmployeeRepo;
import com.ocherestapi.employeemanager.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepo employeeRepo;

    @Autowired
    public void setEmployeeRepo(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with Id " + id + " was not found"));
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public List<Employee> listAllEmployees() {
        return employeeRepo.findAll();
    }
}
