package com.example.demo.controller;

import java.util.List;

import com.example.demo.resource.EmployeeResource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.exception.Checks;
import com.example.demo.service.EmployeeService;

/**
 * @author JavaSolutionsGuide
 */

@RestController
@Api(tags = {"API pour les opérations CRUD sur les employees."})
@RequestMapping(value = "/api/employees")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}


    @ApiOperation(value = "Récupère la liste des employées")
    @GetMapping
    public List<EmployeeResource> getEmployees() {
        return employeeService.retrieveEmployees();
    }

    @ApiOperation(value = "Récupère un employée par ID")
    @GetMapping("{employeeId}")
    public EmployeeResource getEmployee(@PathVariable(name = "employeeId") Long employeeId) {
		return Checks.checkEntityExists(employeeService.getEmployee(employeeId),
				"No Employee found for id  = " + employeeId);    }

    @ApiOperation(value = "Récupère un employée par nom")
    @GetMapping("/name/{name}")
    public EmployeeResource getEmployeeByName(@PathVariable(name = "name") String name) {
        return Checks.checkEntityExists(employeeService.getEmployeeByName(name),
                "No Employee found for id  = " + name);    }

    @PostMapping
    public void create(@RequestBody  Employee employeeResource) {
        employeeService.saveEmployee(employeeResource);
       // System.out.println("Employee Saved Successfully");
    }

    @DeleteMapping("{employeeId}")
    public void deleteEmployee(@PathVariable(name = "employeeId") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        System.out.println("Employee Deleted Successfully");
    }

    @PutMapping("{employeeId}")
    public void updateEmployee(@RequestBody Employee employee,
                               @PathVariable(name = "employeeId") Long employeeId) {
        EmployeeResource emp = employeeService.getEmployee(employeeId);
        if (emp != null) {
            employeeService.updateEmployee(emp.getEmployee());
        }

	}

}