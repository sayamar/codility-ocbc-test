package com.solution.data.repos;

import com.solution.data.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  EmployeeRepo extends JpaRepository<Employee, Long> {
}
