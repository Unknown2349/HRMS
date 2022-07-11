package com.cg.hrms.employee.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hrms.employee.model.Employee;
import com.cg.hrms.employee.repository.EmployeeRepository;

@Service
public class EmployeeService implements EmployeeServiceInterface{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		Employee savedEmployee = employeeRepository.save(employee);
		return savedEmployee;
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmpById(String id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public void deleteEmpById(String id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public Employee updateEmployee(String id, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}