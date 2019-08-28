package com.example.demo.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.employee.Employee;
import com.example.demo.employee.EmployeeRepository;
import com.example.demo.exception.Checks;
import com.example.demo.resource.EmployeeResource;


/**
 * @author JavaSolutionsGuide
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

	@Override
    public List<EmployeeResource> retrieveEmployees() {
        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        final List<EmployeeResource> employeeResources = employees.stream().map(EmployeeResource::new).collect(Collectors.toList());
        return employeeResources;
    }

    @Override
    public EmployeeResource getEmployee(Long employeeId) {
    	Employee employee = Checks.checkEntityExists(employeeRepository.findByIdEmployee(employeeId),"No Employee found for id  = " + employeeId);
        return new EmployeeResource(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);

    }

    @Override
    public void saveEmployee(Employee employee) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteEmployee(Long employeeId) {
    	 employeeRepository.deleteById(employeeId);
    }

}