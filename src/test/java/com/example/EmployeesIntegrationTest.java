package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeesIntegrationTest {
    EmployeeRepository employeeRepository= new EmployeeRepositoryImplementation();
    BankService bankService= new BankServiceImplementation();
    private final Employees employees= new Employees(employeeRepository,bankService);


    @Test
    void payEmployeesTest() {

        employeeRepository.save(new Employee("1",25500));
        employeeRepository.save(new Employee("2",21000));
        employeeRepository.save(new Employee("3",18000));
        employeeRepository.save(new Employee("4",19000));

        assertEquals(4, employees.payEmployees());

    }
    @Test
    void testIfNoEmployees(){
        int numberOfEmployees= employeeRepository.findAll().size();
        assertEquals(0,numberOfEmployees);
    }
}
