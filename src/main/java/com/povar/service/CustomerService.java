package com.povar.service;

import com.povar.domain.Customer;
import com.povar.domain.Developer;
import com.povar.domain.Project;
import com.povar.repository.CustomerDAO;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CustomerService {

    private final CustomerDAO customerDAO;

    public List<Customer> getAllCustomers(){
        return customerDAO.getAllEntities();
    }

    public void deleteCustomer(Long id){
        customerDAO.deleteEntity(id);
    }

    public void addNewCustomer(Customer customer){
        customerDAO.addNewEntity(customer);
    }

    public void updateCustomer(Long id, Customer customer){
        customerDAO.updateEntity(id, customer);
    }
}
