package com.homework21.homework21;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException() {
        super("Такой сотрудник уже есть");
    }
}
