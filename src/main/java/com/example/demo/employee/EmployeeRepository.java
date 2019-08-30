package com.example.demo.employee;

import com.example.demo.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository extends CrudRepository<Employee,Long>{
	public Employee findByName(String name);
 
}