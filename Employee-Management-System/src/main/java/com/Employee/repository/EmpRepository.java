package com.Employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Employee.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer> {

}