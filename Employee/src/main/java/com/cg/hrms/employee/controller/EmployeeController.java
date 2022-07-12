package com.cg.hrms.employee.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hrms.employee.exception.EmployeeNotFoundException;
import com.cg.hrms.employee.exception.NoProperDataException;
import com.cg.hrms.employee.model.Asset;
import com.cg.hrms.employee.model.Employee;
import com.cg.hrms.employee.restclients.AssetClient;
import com.cg.hrms.employee.service.EmployeeServiceInterface;
import com.cg.hrms.employee.service.SequenceGeneratorService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private AssetClient assetclient;


	@Autowired
	private EmployeeServiceInterface employeeServiceInterface;
	
	@PostMapping("/emp/create")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)throws NoProperDataException{
		Employee employeeSaved = employeeServiceInterface.addEmployee(employee);
		return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
	}
	
	
	@PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        employee.setId(SequenceGeneratorService.generateSequence(Employee.SEQUENCE_NAME));
        return employeeServiceInterface.save(employee);
    }
	
	@GetMapping("/emp/get/all")
	public ResponseEntity<List<Employee>> getAllEmployees()throws EmployeeNotFoundException{
		
		List<Employee> listOfAllEmps = employeeServiceInterface.getAllEmployees();
		return new ResponseEntity<List<Employee>>(listOfAllEmps, HttpStatus.OK);
	}
	
//
//@GetMapping(value= "/get/{assetId}")
//	public  ResponseEntity<List<Asset>> getAllAssetsById(@PathVariable("assetId") String assetId){
//		return assetclient.getAllAssetsById();
//	}
//	
	
//	@GetMapping("/getEmployeeByName/{EmployeeName}")
//	public List<Employee>getEmployeeByName(@PathVariable String EmployeeName){
//	    return employeeServiceInterface.findByName(EmployeeName);
//	}
//	
//	
//	@GetMapping("/getEmployeeByAsset/{AssetName}")
//	public List<Employee>getEmployeeByAsset(@PathVariable String AssetName){
//	    return employeeServiceInterface.findbyAssetName(AssetName);
//	}
//
//    if (listOfAllEmps.is Present()) {
//      return new ResponseEntity<>(listOfAllEmps.get(), HttpStatus.OK);
//    } else {
//      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//  }
//	@GetMapping("/asset/get/{id}")
//	  public ResponseEntity<Asset> getAssetById(@PathVariable("id") String id){
//		ResponseEntity<Asset> a=assetclient.getAssetById(id);
//		return a;
//	}
	

	@GetMapping(value= "/get/all")
	public  ResponseEntity<List<Asset>> getAllAssets(){
		return assetclient.getAllAssets();
	}
	
//	@GetMapping("/get/{id}")
//	public ResponseEntity<Asset> getAssetById(@PathVariable("id") String id){
//		return assetclient.getAssetById(id);
//	}
	@PostMapping(value = "/create")
	public ResponseEntity<Asset>  addAsset(@RequestBody Asset asset) {
		return assetclient.addAsset(asset);
	}
	
	@GetMapping("/emp/get/{id}")
	public ResponseEntity<Employee> getEmpById(@PathVariable("id") String id)throws EmployeeNotFoundException{
		
		Employee empRetrieved = employeeServiceInterface.getEmpById(id);
		return new ResponseEntity<Employee>(empRetrieved, HttpStatus.OK);
	}
	
	@DeleteMapping("emp/delete/{id}")
	public ResponseEntity<Void> deleteEmpById(@PathVariable("id") String id){
		
		employeeServiceInterface.deleteEmpById(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("emp/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") String id,@RequestBody Employee employee)throws EmployeeNotFoundException{
		Employee employeeSaved = employeeServiceInterface.updateEmployee(id,employee);
		return new ResponseEntity<Employee>(employeeSaved, HttpStatus.CREATED);
	}

	
	
}

