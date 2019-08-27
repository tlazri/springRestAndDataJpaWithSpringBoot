package com.example.demo.service;
import java.util.List;

import com.example.demo.employee.Employee;
import com.example.demo.resource.EmployeeResource;

public interface EmployeeService {
	 public List<EmployeeResource> retrieveEmployees();
	  
	 public EmployeeResource getEmployee(Long employeeId);

	 public void saveEmployee(Employee employee);
	  
	 public void deleteEmployee(Long employeeId);
	  
	 public void updateEmployee(Employee employee);

}
