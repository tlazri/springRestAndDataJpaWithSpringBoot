package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.resource.EmployeeResource;

import java.util.List;

public interface EmployeeService {
	 public List<EmployeeResource> retrieveEmployees();
	  
	 public EmployeeResource getEmployee(Long employeeId);

	 public EmployeeResource getEmployeeByName(String name);

	 public void saveEmployee(Employee employee);
	  
	 public void deleteEmployee(Long employeeId);
	  
	 public void updateEmployee(Employee employee);

}
