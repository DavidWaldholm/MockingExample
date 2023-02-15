package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeRepositoryImplementation implements EmployeeRepository {

    private Map<String, Employee> employees;

    public EmployeeRepositoryImplementation() {
        this.employees = new HashMap<>();
    }

    public EmployeeRepositoryImplementation(List<Employee> employees) {
        this.employees = new HashMap<>();
        employees.forEach(employee -> this.employees.put(employee.getId(), employee));
    }

    @Override
    public List<Employee> findAll() {
        return employees.values().stream().toList();
    }

    @Override
    public Employee save(Employee e) {
        employees.put(e.getId(), e);
        return e;
    }
}
