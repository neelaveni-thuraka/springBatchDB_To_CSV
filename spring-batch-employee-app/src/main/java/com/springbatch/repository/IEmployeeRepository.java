package com.springbatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbatch.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>  {
 
}
