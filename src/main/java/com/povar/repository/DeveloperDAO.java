package com.povar.repository;

import com.povar.Main;

import java.sql.*;
import java.util.Scanner;

public class DeveloperDAO {

    Connection connection;
    Statement statement;


    String query = "INSERT INTO `my_db`.`developers` ( `name`, `gender`, `age` ,'salary') VALUES ( '";

    public void addNewDeveloper(){
        try {
            connection = DriverManager.getConnection(Main.getURL(), Main.getUSER(), Main.getPASSWORD());
            statement = connection.createStatement();
            statement.executeUpdate(createStatementOfNewDeveloper());

            connection.close();
            statement.close();
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    private String createStatementOfNewDeveloper(){
        StringBuilder stringBuilder = new StringBuilder(query);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter developer name: ");
        String addToQuery = scanner.next();
        stringBuilder.append(addToQuery + "', '");
        System.out.print("Enter developer gender: ");
        addToQuery = scanner.next();
        stringBuilder.append(addToQuery + "', '");
        System.out.print("Enter developer age: ");
        addToQuery = scanner.next();
        stringBuilder.append(addToQuery + "', '");
        System.out.print("Enter developer salary: ");
        addToQuery = scanner.next();
        stringBuilder.append(addToQuery + "' ) ");

        return query = stringBuilder.toString();
    }
}
