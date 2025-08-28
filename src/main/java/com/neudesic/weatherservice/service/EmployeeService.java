package com.neudesic.weatherservice.service;

import com.neudesic.weatherservice.model.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    private final Map<String,Employee> employeeMap = new HashMap<>();

    public List<Employee> getEmployees(){
        return employeeMap.values().stream().toList();
    }

    public Employee create(Employee employee) {
        employee.setId(UUID.randomUUID().toString());
        employeeMap.put(employee.getId(), employee);
        return employee;
    }

    public Optional<Employee> getEmployee(String id) {
        return Optional.ofNullable(employeeMap.get(id));
    }
    public Employee update(Employee employee) {
        employeeMap.put(employee.getId(), employee);
        return employee;
    }

    public void remove(String id) {
        employeeMap.remove(id);
    }
}
