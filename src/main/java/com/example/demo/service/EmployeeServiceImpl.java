package com.example.demo.service;


import com.example.demo.employee.EmployeeRepository;
import com.example.demo.exception.Checks;
import com.example.demo.model.Employee;
import com.example.demo.resource.EmployeeResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * @author JavaSolutionsGuide
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeResource> retrieveEmployees() {
        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        final List<EmployeeResource> employeeResources = employees.stream().map(EmployeeResource::new).collect(Collectors.toList());
        return employeeResources;
    }

    @Override
    public EmployeeResource getEmployee(Long employeeId) {
    	Optional<Employee> employee = Checks.checkEntityExists(employeeRepository.findById(employeeId),"No Employee found for id  = " + employeeId);
        return new EmployeeResource(employee.get());
    }

    @Override
    public EmployeeResource getEmployeeByName(String name) {
        return new EmployeeResource(employeeRepository.findByName(name));
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);

    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
    	 employeeRepository.deleteById(employeeId);
    }



}