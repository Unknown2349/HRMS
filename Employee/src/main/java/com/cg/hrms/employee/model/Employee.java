package com.cg.hrms.employee.model;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data 
@Document(collection = "emp")
public class Employee {
	
	@Id
	
    private String id;
	public static final String SEQUENCE_NAME="emp_sequence";
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Size(min=3,max=12,message ="Name lenght must be min 3 and max 12")
	private String employeeName;
	@Size(min=3,max=30,message = "Department length must be min 5 and max 30")
	private String employeeDepartment;
	@Size(min=3,max=30,message = "Designation length must be min 5 and max 30")
	private String employeeDesignation;

	@Min(value = 5000,message = "Salary minimum is 5000")
	@Max(value =  1000000,message = "salary maximum is 100000")
	private long  employeeSalary;
	private List<Asset> assets;
 	public Employee() {
		super();
		
	}
	public Employee(String employeeName, String employeeDepartment, String employeeDesignation, long  employeeSalary) {
		super();
		this.employeeName = employeeName;
		this.employeeDepartment = employeeDepartment;
		this.employeeDesignation = employeeDesignation;
		this.employeeSalary = employeeSalary;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeDepartment() {
		return employeeDepartment;
	}
	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}
	public String getEmployeeDesignation() {
		return employeeDesignation;
	}
	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}
	public long getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(long employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	public List<Asset> getAssets() {
		return assets;
	}
	public void setAssets(List<Asset> assets) {
		this.assets = assets;
	}

	
	
	

}
