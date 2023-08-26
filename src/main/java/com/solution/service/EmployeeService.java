package com.solution.service;

import com.solution.data.entities.Employee;
import com.solution.data.repos.EmployeeRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    public void delete(Long id) {
        employeeRepo.deleteById(id);
    }

    public List<Employee> getEmployees(String searchTerm) {
        List<Employee> employeeList = employeeRepo.findAll();
        return getEmployeesByCriterai(searchTerm, employeeList);
    }

    public Map<String, Long> getEmployeesGroupBy(String groupBy) {
        List<Employee> employeeList = employeeRepo.findAll();
        return getEmployeesGroup(groupBy, employeeList);
    }

    private Map<String, Long> getEmployeesGroup(String groupBy, List<Employee> employeeList) {
        if (groupBy.equals("country")) {
            return employeeList.stream()
                    .collect(Collectors.groupingBy(Employee::getCountry, Collectors.summingLong(Employee::getSalary)));
        }
        return new HashMap<>();
    }


    private List<Employee> getEmployeesByCriterai(String searchTerm, List<Employee> employeeList) {

        if (searchTerm.equals("name")) {
            return employeeList.stream()
                    .filter(employee -> employee.getName().equals(searchTerm))
                    .collect(Collectors.toList());

        }
        if (searchTerm.equals("age")) {
            return employeeList.stream()
                    .filter(employee -> employee.getAge() == Integer.parseInt(searchTerm))
                    .collect(Collectors.toList());
        }

        if (searchTerm.equals("salary")) {
            return employeeList.stream()
                    .filter(employee -> employee.getSalary() == Integer.parseInt(searchTerm))
                    .collect(Collectors.toList());
        }

        if (searchTerm.equals("country")) {
            return employeeList.stream()
                    .filter(employee -> employee.getCountry().equals(searchTerm))
                    .collect(Collectors.toList());
        }


        return employeeList;
    }

    public void loadEmployeeData() {
        String country = "";

        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0) {
                country = "Singapore";
            } else {
                country = "India";
            }
            Employee employee = Employee.builder()
                    .name("name" + i)
                    .email("email" + i)
                    .phone("phone" + i)
                    .address("address" + i)
                    .age(i)
                    .city("city" + i)
                    .state("state" + i)
                    .country(country)
                    .zipCode("zipCode" + i)
                    .salary(Long.valueOf(i))
                    .build();
            employeeRepo.save(employee);
        }


    }
}
