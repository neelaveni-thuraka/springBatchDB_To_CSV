package com.springbatch.service;

import java.util.List;
import java.util.Optional;

import com.springbatch.entity.Employee;


public interface IEmployeeService {
	public List<Employee> findAll();

	public Optional<Employee> findById(int id);
}
