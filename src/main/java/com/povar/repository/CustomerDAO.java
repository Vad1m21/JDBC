package com.povar.repository;

import com.povar.domain.Customer;
import lombok.extern.slf4j.Slf4j;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CustomerDAO extends GenericDAO<Customer,Long> {


    @Override
    protected String createQueryForUpdate(Long id, Customer customer) {
        return String.format("UPDATE `my_db`.`customers` SET name = '%s', email = '%s' WHERE customer_id = '%d'", customer.getName(), customer.getEmail(), id);
    }

    @Override
    protected String getTableName() {
        return "customers";
    }

    @Override
    protected String createQuery(Customer customer) {
        return String.format("INSERT INTO `my_db`.`customers` (`name`, `gender`) VALUES ('%s','%s')", customer.getName(), customer.getEmail());
    }

    @Override
    protected List<Customer> convertToList(ResultSet resultSet) {
        List<Customer> customers = new ArrayList<>();
        try{
            while (resultSet.next()){
                Customer customer = new Customer();
                customer.setId(resultSet.getLong("customer_id"));
                customer.setName(resultSet.getString("name"));
                customer.setEmail(resultSet.getString("email"));
                customers.add(customer);
            }
        }catch (SQLException exception){
            log.error("Error occurred while converting result set to list.Cause: {}",exception.getMessage());
        }

        return customers;
    }

    @Override
    protected String getColumnId() {
        return "customer_id";
    }
}
