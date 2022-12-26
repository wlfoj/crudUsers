package com.example.crudUsers.controller;

import com.example.crudUsers.model.Employee;
import com.example.crudUsers.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")//Aqui é o prefixo da api
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @ApiOperation(value = "Lista todos os funcionarios")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operação concluida"),
            @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 400, message = "Requisição incoerente"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAll(){
        try {
            List<Employee> _employee = employeeService.findAll();
            return new ResponseEntity<>(_employee, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Obtem um funcionario pelo id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operação concluida"),
            @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 400, message = "Requisição incoerente"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") long id){
        try {
            Employee _e = employeeService.findById(id);
            //Se tiver achado
            if (_e != null) {
                return new ResponseEntity<>(_e, HttpStatus.OK);
            }
            //se não achar
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Registro de novo funcionario")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Funcionario registrado"),
            @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 400, message = "Requisição incoerente"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        try {
            Employee _employee  = employeeService.save(employee);
            return new ResponseEntity<>(_employee, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Atualiza dados de um funcionario")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Atualização concluida"),
            @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 400, message = "Requisição incoerente"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
        try {
            Employee _employee = employeeService.edit(id, employee);
            if (_employee != null) {
                return new ResponseEntity<>(_employee, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @ApiOperation(value = "Deleta funcionario")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Operação concluida"),
            @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 400, message = "Requisição incoerente"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") long id) {
        try {
            employeeService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
