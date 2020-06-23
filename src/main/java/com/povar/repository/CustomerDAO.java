package com.povar.repository;

import com.povar.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CustomerDAO {



    Connection connection;
    Statement statement;


    String query = "INSERT INTO `my_db`.`customers` (`name`, `gender`) VALUES ('";

    public void addNewCustomer(){
        try {
            connection = DriverManager.getConnection(Main.getURL(), Main.getUSER(), Main.getPASSWORD());
            statement = connection.createStatement();
            statement.executeUpdate(createStatementOfNewCustomer());


            connection.close();
            statement.close();
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
    }


    private String createStatementOfNewCustomer(){
        StringBuilder stringBuilder = new StringBuilder(query);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        String addToQuery = scanner.next();
        stringBuilder.append(addToQuery + "', '");
        System.out.print("Enter customer gender: ");
        addToQuery = scanner.next();
        stringBuilder.append(addToQuery + "') ");

        return query = stringBuilder.toString();
    }
}
