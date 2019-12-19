package com.springbatch.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbatch.entity.Employee;
import com.springbatch.repository.IEmployeeRepository;
import com.springbatch.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private IEmployeeRepository repository;

	@Override
	public List<Employee> findAll() {
		System.out.println("gettng emp findAll============ ");
		List<Employee> employees = (List<Employee>) repository.findAll();

		return employees;
	}

	@Override
	public Optional<Employee> findById(int empID) {

		Optional<Employee> employee = (Optional<Employee>) repository.findById(empID);
		return employee;
	}

}
