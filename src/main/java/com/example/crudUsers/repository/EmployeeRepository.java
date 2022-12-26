package com.example.crudUsers.repository;

import com.example.crudUsers.model.Department;
import com.example.crudUsers.model.Employee;
import com.example.crudUsers.model.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllByDepartment(Department department);
    List<Employee> findAllByType(EmployeeType type);
}
