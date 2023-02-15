package com.example;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
public class EmployeesMockitoTest {
    EmployeeRepository employeeRepository=mock(EmployeeRepository.class);
    BankService bankService = mock(BankService.class);
    private final Employees employees = new Employees(employeeRepository, bankService);
    Employee employee = mock(Employee.class);

    @Test
    void payEmployees() {
        when(employeeRepository.findAll()).thenReturn(List.of(employee));
        when(employeeRepository.save(any(Employee.class))).then(returnsFirstArg());

        assertEquals(1, employees.payEmployees());
        verify(employee, times(1)).getSalary();
        verify(employee, times(1)).setPaid(true);
    }
}
