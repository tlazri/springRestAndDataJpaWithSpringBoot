package com.example.demo.service;

import com.example.demo.SpringRestAndDataJpaWithSpringBootApplication;
import com.example.demo.employee.EmployeeRepository;
import com.example.demo.model.Employee;
import com.example.demo.resource.EmployeeResource;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringRestAndDataJpaWithSpringBootApplication.class)
@WebAppConfiguration
public class EmployeeServiceTest {


    @Mock
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeServiceImpl employeeService;
    private List<EmployeeResource> employeeResources;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        employeeResources = new ArrayList<>();
        employeeResources.add(new EmployeeResource(new Employee("dsd",454545,"454545")));
    }

    @Test
    public void persisting_getEmployee() {
       EmployeeResource res  = employeeService.getEmployee(1L);

        // test by filter name inserted on DB with findAny method
        Assert.assertNotNull(res);
    }

    @Test
    public void persisting_deleteEmployee() {
        long t = employeeService.retrieveEmployees().stream().count();
        employeeService.deleteEmployee(1L);

        // test by employee stored size
        Assert.assertEquals(t-1, employeeService.retrieveEmployees().stream().count());

    }

    @Test
    public void whenFindAllById() {
        //given
        Employee emp = new Employee();
        emp.setName("Name xx");
        employeeService.saveEmployee(emp);

        //when
        EmployeeResource testEmployee = employeeService.getEmployeeByName("Name xx");

        //then
        Assert.assertEquals(emp.getName(), testEmployee.getEmployee().getName());
    }
    @Test
    public void persisting_updateEmployee() {
        EmployeeResource testEmployee = employeeService.getEmployeeByName("Name 1");
        Long id = testEmployee.getEmployee().getId();
        testEmployee.getEmployee().setName("New name");

        employeeService.updateEmployee(testEmployee.getEmployee());

        EmployeeResource res  = employeeService.getEmployee(id);

        Assert.assertEquals("New name", res.getEmployee().getName());
    }

    @Test
    public void persisting_newEmployee() {
        Employee employee = new Employee();
        employee.setDepartment("Author1");
        employee.setName("name 11");
        employee.setSalary(256546);
        employeeService.saveEmployee(employee);

        // test by filter name inserted on DB with count method
        Assert.assertTrue(employeeService.retrieveEmployees().stream().filter(employeeS -> employeeS.getEmployee().getName().equals("name 11")).count() == 1);

        // test by filter name inserted on DB with findAny method
        Assert.assertNotNull(employeeService.retrieveEmployees().stream().filter(employeeS -> employeeS.getEmployee().getName().equals("name 11")).findAny().get());

        // test by employee stored size
        Assert.assertEquals(4,employeeService.retrieveEmployees().size());
    }

//    @Test
//    public void persisting_newEmployee2() {
////        //ArgumentCaptor<EmployeeResource> peopleCaptor = ArgumentCaptor.forClass(EmployeeResource.class);
//       //EmployeeService mock = org.mockito.Mockito.mock(EmployeeServiceImpl.class);
////
//       Mockito.when(employeeService.retrieveEmployees()).thenReturn(employeeResources);
////        employeeService.retrieveEmployees();
////
////        Mockito.verify(employeeService).retrieveEmployees();
////        EmployeeRepository employeeRepository = Mockito.mock(EmployeeRepository.class);
//
//        employeeService.retrieveEmployees();
//
//        // verify if the findAll method is called when retrieveEmployees is called too
//        Mockito.verify(employeeRepository, times(1)).findAll();
//    }
}