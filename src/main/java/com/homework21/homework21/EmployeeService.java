package com.homework21.homework21;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private Map<String, Employee> employees = new HashMap<>();

    public Employee addEmployee(String firstName, String lastName) {
        if (employees.containsKey(firstName + " " + lastName)) {
            throw new EmployeeAlreadyAddedException();
        }
        Employee employee = new Employee(firstName, lastName);
        employees.put(firstName + " " + lastName, employee);
        System.out.println("Сотрудник добавлен");
        return employee;
    }

    public Employee deleteEmployee(String firstName, String lastName) {
        if (employees.containsKey(firstName + " " + lastName)) {
            Employee employee = employees.get(firstName + " " + lastName);
            employees.remove(firstName + " " + lastName);
            System.out.println("Сотрудник удален");
            return employee;
        }

        throw new EmployeeNotFoundException();
    }
    public Employee findEmployee(String firstName, String lastName) {
        if (employees.containsKey(firstName + " " + lastName)) {
            Employee employee = employees.get(firstName + " " + lastName);
            return employee;
        }

        throw new EmployeeNotFoundException();
    }

    public List<Employee> printEmployees() {
        return new ArrayList<>(employees.values());
    }
}
