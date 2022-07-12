package com.cg.hrms.employee.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.hrms.employee.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository< Employee, String>{

	

}
