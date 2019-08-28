package com.example.demo.controller;

import java.util.List;

import com.example.demo.resource.EmployeeResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.employee.Employee;
import com.example.demo.exception.Checks;
import com.example.demo.service.EmployeeService;

/**
 * @author JavaSolutionsGuide
 */

@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/api/employees")
	public List<EmployeeResource> getEmployees() {
		return employeeService.retrieveEmployees();
	}

	@GetMapping("/api/employees/{employeeId}")
	public EmployeeResource getEmployee(@PathVariable(name = "employeeId") Long employeeId) {
		// EmployeeResource employee=employeeService.getEmployee(employeeId);
		// EmployeeResource checkEntityExists =
		return Checks.checkEntityExists(employeeService.getEmployee(employeeId),
				"No Employee found for id  = " + employeeId);

		// return employee;
	}

	@PostMapping("/api/employees")
	public void saveEmployee(Employee employee) {
		employeeService.saveEmployee(employee);
		System.out.println("Employee Saved Successfully");
	}

	@DeleteMapping("/api/employees/{employeeId}")
	public void deleteEmployee(@PathVariable(name = "employeeId") Long employeeId) {
		employeeService.deleteEmployee(employeeId);
		System.out.println("Employee Deleted Successfully");
	}

	@PutMapping("/api/employees/{employeeId}")
	public void updateEmployee(@RequestBody Employee employee, @PathVariable(name = "employeeId") Long employeeId) {
		EmployeeResource emp = employeeService.getEmployee(employeeId);
		if (emp != null) {
			employeeService.updateEmployee(emp.getEmployee());
		}

	}

}