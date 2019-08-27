package com.example.demo.resource;

import com.example.demo.employee.Employee;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotNull;

public class EmployeeResource {

    private final Employee employee;

    @JsonCreator
    public EmployeeResource(@NotNull final Employee employee) {
        this.employee = employee;
        //this.add(linkTo(EmployeeRestController.class).slash(employee.getId()).withSelfRel());
    }

    public Employee getEmployee() {
        return employee;
    }

    @Override
    public String toString() {
        return "EmployeeResource [employee=" + employee + ", toString()=" + super.toString() + "]";
    }
}
