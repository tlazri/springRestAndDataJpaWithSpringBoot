package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Employee {

 @Id
 @JsonIgnore
 @GeneratedValue(strategy= GenerationType.IDENTITY)
 private Long id;
 private String name;
 private Integer salary;
 private String department;

 public Employee() {
 }

 public Employee(String name, Integer salary, String department) {
  this.name = name;
  this.salary = salary;
  this.department = department;
 }

 public Long getId() {
  return id;
 }
 
 public void setId(Long id) {
  this.id = id;
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

 @Override
 public int hashCode() {
  final int prime = 31;
  int result = 1;
  result = prime * result + ((name == null) ? 0 : name.hashCode());
  result = prime * result + ((salary == null) ? 0 : salary.hashCode());
  result = prime * result + ((department == null) ? 0 : department.hashCode());
  return result;
 }

 @Override
 public boolean equals(Object obj) {
  if (this == obj)
   return true;
  if (obj == null)
   return false;
  if (getClass() != obj.getClass())
   return false;
  Employee other = (Employee) obj;
  if (name == null) {
   if (other.name != null)
    return false;
  } else if (!name.equals(other.name))
   return false;
  if (department == null) {
   if (other.department != null)
    return false;
  } else if (!department.equals(other.department))
   return false;
  if (salary == null) {
   if (other.salary != null)
    return false;
  } else if (!salary.equals(other.salary))
   return false;
  return true;
 }
}