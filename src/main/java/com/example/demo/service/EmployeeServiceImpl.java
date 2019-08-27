package com.example.demo.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.demo.resource.EmployeeResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.employee.Employee;
import com.example.demo.employee.EmployeeRepository;


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

    public List<EmployeeResource> retrieveEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        final List<EmployeeResource> employeeResources = employees.stream().map(EmployeeResource::new).collect(Collectors.toList());
        return employeeResources;
    }

    @Override
    public EmployeeResource getEmployee(Long employeeId) {
        Optional<Employee> optEmp = employeeRepository.findById(employeeId);
        return new EmployeeResource(optEmp.get());
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

    }
}