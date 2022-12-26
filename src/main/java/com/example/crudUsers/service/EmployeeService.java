package com.example.crudUsers.service;

import com.example.crudUsers.model.Department;
import com.example.crudUsers.model.Employee;
import com.example.crudUsers.model.EmployeeType;
import com.example.crudUsers.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepo;

    public Employee save(Employee employee) {
        Employee _employee = employeeRepo.save(employee);
        return _employee;
    }

    public List<Employee> findAll(){
        List<Employee> all = employeeRepo.findAll();
        return all;
    }


    public Employee findById(long id) {
        Employee _employee = null;
        Optional<Employee> result = employeeRepo.findById(id);

        if(result.isPresent()) {
            _employee = result.get();
        }

        return _employee;
    }

    public List<Employee> findAllByDepart(Department department) {
        List<Employee> result = employeeRepo.findAllByDepartment(department);
        return result;
    }


    public List<Employee> findAllByDType(EmployeeType type) {
        List<Employee> result = employeeRepo.findAllByType(type);
        return result;
    }


    public Employee edit(long id, Employee employee) {
        Employee editedEmployee = null;
        // Verifica se existe alguém com o id
        Optional<Employee> _employee = employeeRepo.findById(id);
        // Se tiver preenche
        if (_employee.isPresent()) {
            editedEmployee = _employee.get();
            editedEmployee.setAddres(employee.getAddres());
            editedEmployee.setEmail(employee.getEmail());
            editedEmployee.setName(employee.getName());
            editedEmployee.setPhone(employee.getPhone());
            editedEmployee.setBirth(employee.getBirth());
            editedEmployee.setCpf(employee.getCpf());

            editedEmployee.setDepartment(employee.getDepartment());
            editedEmployee.setSalary(employee.getSalary());
            editedEmployee.setType(employee.getType());
            editedEmployee = employeeRepo.save(editedEmployee);
        }
        return editedEmployee;
    }


    public void deleteById(long id) {
        employeeRepo.deleteById(id);
    }
}
