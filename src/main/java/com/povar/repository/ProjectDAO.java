package com.povar.repository;

import com.povar.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProjectDAO {


    Connection connection;
    Statement statement;


    String query = " INSERT INTO `my_db`.`projects` (`name`, `description`, `date`, 'cost') VALUES ('";

    public void addNewProject(){
        try {
            connection = DriverManager.getConnection(Main.getURL(), Main.getUSER(), Main.getPASSWORD());
            statement = connection.createStatement();
            statement.executeUpdate(createStatementOfNewProject());


            connection.close();
            statement.close();
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
    }


    private String createStatementOfNewProject(){
        StringBuilder stringBuilder = new StringBuilder(query);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter project name: ");
        String addToQuery = scanner.next();
        stringBuilder.append(addToQuery + "', '");
        System.out.print("Enter project description: ");
        addToQuery = scanner.next();
        stringBuilder.append(addToQuery + "', '");
        System.out.print("Enter project date: ");
        addToQuery = scanner.next();
        stringBuilder.append(addToQuery + "', '");
        System.out.print("Enter project cost: ");
        addToQuery = scanner.next();
        stringBuilder.append(addToQuery + "') ");

        return query = stringBuilder.toString();
    }
}
