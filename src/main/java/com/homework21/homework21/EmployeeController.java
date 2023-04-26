package com.homework21.homework21;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping( "/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Employee add(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping( "/remove")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.deleteEmployee(firstName, lastName);
    }

    @GetMapping( "/find")
    @ResponseStatus(code = HttpStatus.OK)
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping( "/all")
    public List<Employee> getEmployees() {
        return employeeService.printEmployees();
    }
}
