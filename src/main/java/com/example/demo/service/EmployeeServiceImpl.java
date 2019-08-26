package com.example.demo.service;


 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.employee.Employee;
import com.example.demo.employee.EmployeeRepository;


 
/**
 * @author JavaSolutionsGuide
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
 
 @Autowired
 private EmployeeRepository employeeRepository;
 
 public void setEmployeeRepository(EmployeeRepository employeeRepository) {
  this.employeeRepository = employeeRepository;
 }
  
 public List<Employee> retrieveEmployees() {
  List<Employee> employees = employeeRepository.findAll();
  return employees;
 }
  
 public Employee getEmployee1(Long employeeId) {
  Optional<Employee> optEmp = employeeRepository.findById(employeeId);
  return optEmp.get();
 }
  
 public void saveEmployee1(Employee employee){
  employeeRepository.save(employee);
 }
  
 public void deleteEmployee(Long employeeId){
  employeeRepository.deleteById(employeeId);
 }
  
 public void updateEmployee1(Employee employee) {
  employeeRepository.save(employee);
 }

@Override
public Employee getEmployee(Long employeeId) {
	Optional<Employee> optEmp = employeeRepository.findById(employeeId);
	  return optEmp.get();
}

//@Override
//public void saveEmployee(Employee employee) {
//	 Optional<Employee> optEmp = employeeRepository.save(employe);
//	 
//	
//}

@Override
public void updateEmployee(Employee employee) {
	employeeRepository.save(employee);
	
}

@Override
public void saveEmployee(Employee employee) {
	// TODO Auto-generated method stub
	
}
}