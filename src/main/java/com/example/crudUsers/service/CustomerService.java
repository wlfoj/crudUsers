package com.example.crudUsers.service;

import com.example.crudUsers.model.Customer;
import com.example.crudUsers.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepo;

    public Customer save(Customer customer) {
        Customer _customer = customerRepo.save(customer);
        return _customer;
    }

    public List<Customer> findAll(){
        List<Customer> all = customerRepo.findAll();
        return all;
    }


    public Customer findById(long id) {
        Customer _customer = null;
        Optional<Customer> result = customerRepo.findById(id);

        if(result.isPresent()) {
            _customer = result.get();
        }

        return _customer;
    }


    public Customer edit(long id, Customer customer) {
        Customer editedCustomer = null;
        // Verifica se existe alguém com o id
        Optional<Customer> _customer = customerRepo.findById(id);
        // Se tiver preenche
        if (_customer.isPresent()) {
            editedCustomer = _customer.get();
            editedCustomer.setAddres(customer.getAddres());
            editedCustomer.setEmail(customer.getEmail());
            editedCustomer.setName(customer.getName());
            editedCustomer.setPhone(customer.getPhone());
            editedCustomer.setBirth(customer.getBirth());
            editedCustomer.setCpf(customer.getCpf());

            editedCustomer.setDateJoined(customer.getDateJoined());
            editedCustomer.setLastPurchase(customer.getLastPurchase());
            editedCustomer = customerRepo.save(editedCustomer);
        }
        return editedCustomer;
    }


    public void deleteById(long id) {
        customerRepo.deleteById(id);
    }
}
