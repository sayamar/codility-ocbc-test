package com.solution.api.controller;

import com.solution.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Map;

@RestController
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employee")
    public Map<String,Long> getEmployeesGroupBy(@RequestParam String groupBy) {
        return employeeService.getEmployeesGroupBy(groupBy);
    }

    @PostConstruct
   public void loadEmployeeData(){
        employeeService.loadEmployeeData();
   }
}
