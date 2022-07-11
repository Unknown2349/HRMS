package com.cg.hrms.employee.service;

import java.util.List;

import com.cg.hrms.employee.model.Employee;



public interface EmployeeServiceInterface {

	public Employee addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public Employee getEmpById(String id);

	public void deleteEmpById(String id);
	
	

	Employee updateEmployee(String id, Employee employee);

}