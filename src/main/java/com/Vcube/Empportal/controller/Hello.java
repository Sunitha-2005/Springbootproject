package com.Vcube.Empportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Vcube.Empportal.model.Employee;
import com.Vcube.Empportal.repo.EmployeeRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class Hello {

    @Autowired
    EmployeeRepo employeeRepo;

    // Test API
    @GetMapping("/Hello")
    String hello() {
        return "hello welcome to vcube";
    }

    // GET ALL EMPLOYEES
    @GetMapping("/getEmpList")
    List<Employee> getAllEmployeeDetails() {
        return employeeRepo.findAll();
    }

    // GET ONE EMPLOYEE
    // Example: http://localhost:9999/getEmp/15
    @GetMapping("/getEmp/{eid}")
    Employee getEmployee(@PathVariable Integer eid) {
        return employeeRepo.findById(eid).orElseThrow();
    }

    // CREATE EMPLOYEE
    @PostMapping("/createEmployee")
    Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepo.save(employee);
    }

    // UPDATE EMPLOYEE
    // Example: http://localhost:9999/updateEmp/15
    @PutMapping("/updateEmp/{eid}")
    Employee updateEmployee(
            @RequestBody Employee employee,
            @PathVariable Integer eid) {

        Employee empFromDb = employeeRepo.findById(eid).orElseThrow();

        empFromDb.setAge(employee.getAge());
        empFromDb.setCity(employee.getCity());
        empFromDb.setEname(employee.getEname());
        empFromDb.setSalary(employee.getSalary());
        empFromDb.setState(employee.getState());

        return employeeRepo.save(empFromDb);
    }

    // DELETE EMPLOYEE
    // Example: http://localhost:9999/delEmp/15
    @DeleteMapping("/delEmp/{eid}")
    String deleteEmployee(@PathVariable Integer eid) {

        employeeRepo.deleteById(eid);

        return "Employee has been deleted successfully with id of " + eid;
    }
}