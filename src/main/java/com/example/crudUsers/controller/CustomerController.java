package com.example.crudUsers.controller;

import com.example.crudUsers.model.Customer;
import com.example.crudUsers.service.CustomerService;
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
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @ApiOperation(value = "Lista todos os clientes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operação concluida"),
            @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 400, message = "Requisição incoerente"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getAll(){
        try {
            List<Customer> _customer = customerService.findAll();
            return new ResponseEntity<>(_customer, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Obtem um cliente pelo id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operação concluida"),
            @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 400, message = "Requisição incoerente"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getById(@PathVariable("id") long id){
        try {
            Customer _c = customerService.findById(id);
            //Se tiver achado
            if (_c != null) {
                return new ResponseEntity<>(_c, HttpStatus.OK);
            }
            //se não achar
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Registro de novo cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Funcionario registrado"),
            @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 400, message = "Requisição incoerente"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        try {
            Customer _customer = customerService.save(customer);
            return new ResponseEntity<>(_customer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Atualiza dados de um cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Atualização concluida"),
            @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 400, message = "Requisição incoerente"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer){
        try {
            Customer _customer = customerService.edit(id, customer);
            if (_customer != null) {
                return new ResponseEntity<>(_customer, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @ApiOperation(value = "Deleta cliente")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Operação concluida"),
            @ApiResponse(code = 401, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 400, message = "Requisição incoerente"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @DeleteMapping("/customer/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") long id) {
        try {
            customerService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
