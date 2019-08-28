package com.example.demo.employee;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
/**
 * @author JavaSolutionsGuide
 *
 */
@Entity
@Table(name="EMPLOYEE")
public class Employee {
  
 @Id
 @GeneratedValue(strategy= GenerationType.IDENTITY)
 @Column(name="ID_EMPLOYEE")
 private Long idEmployee;
  
 @Column(name="EMPLOYEE_NAME")
 private String name;
  
 @Column(name="EMPLOYEE_SALARY")
 private Integer salary;
  
 @Column(name="DEPARTMENT")
 private String department;
 
 public Long getIdEmployee() {
  return idEmployee;
 }
 
 public void setIdEmployee(Long idEmployee) {
  this.idEmployee = idEmployee;
 }
 
 public String getName() {
  return name;
 }
 
 public void setName(String name) {
  this.name = name;
 }
 
 public Integer getSalary() {
  return salary;
 }
 
 public void setSalary(Integer salary) {
  this.salary = salary;
 }
 
 public String getDepartment() {
  return department;
 }
 
 public void setDepartment(String department) {
  this.department = department;
 }
}