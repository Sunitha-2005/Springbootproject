package com.Vcube.Empportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Vcube.Empportal.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}