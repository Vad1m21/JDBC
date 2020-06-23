package com.povar.service;

import com.povar.repository.CustomerDAO;

public class CustomerService {



    public void addNewCustomer(){
       new CustomerDAO().addNewCustomer();
    }
}
