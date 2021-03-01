package com.ocherestapi.employeemanager.controllers;

import com.ocherestapi.employeemanager.model.Employee;
import com.ocherestapi.employeemanager.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee") //default or base url
public class EmployeeController {
    final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employees = employeeService.listAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee saveEmployee = employeeService.addEmployee(employee);
        return  new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee saveEmployee = employeeService.updateEmployee(employee);
        return  new ResponseEntity<>(saveEmployee, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
