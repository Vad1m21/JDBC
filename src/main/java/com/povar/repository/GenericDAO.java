package com.povar.repository;

import com.povar.Main;
import com.povar.connection.ConnectionDB;
import com.povar.domain.Customer;
import com.povar.domain.Developer;
import com.povar.domain.GenderOfDevelopers;
import com.povar.domain.Project;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Data
@RequiredArgsConstructor
public class GenericDAO<T> {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private ConnectionDB connectionDB;

    public void addNewEntity(T value) {
        String query = " ";
        if (value instanceof Developer) {
            query = String.format("INSERT INTO `my_db`.`developers` ( `name`, `gender`, `age` ,'salary') VALUES ( '%s','%s', '%d', '%s')", ((Developer) value).getName(), ((Developer) value).getGenderOfDevelopers(), ((Developer) value).getAge(), ((Developer) value).getSalary());
        } else if (value instanceof Customer) {
            query = String.format("INSERT INTO `my_db`.`customers` (`name`, `gender`) VALUES ('%s','%s')", ((Customer) value).getName(), ((Customer) value).getEmail());
        } else if (value instanceof Project) {
            query = String.format(" INSERT INTO `my_db`.`projects` (`name`, `description`, `date`, 'cost') VALUES ('%s','%s','%t','%d'", ((Project) value).getName(), ((Project) value).getDescription(), ((Project) value).getDate(), ((Project) value).getCost());

        }

        connectionDB.ConnectionToDBWithExecuteUpdate(query);
        connectionDB.closeConnection();

    }

    public void getAllEntities(T value) {
        String query = " ";
        String entityName = "";
        if (value instanceof Developer) {
            query = "Select d.developers_id,d.name From developers d ";
            entityName = "Developer: ";
        } else if (value instanceof Customer) {
            query = "Select c.customer_id,c.name From customers c ";
            entityName = "Customer: ";
        } else if (value instanceof Project) {
            query = "Select p.project_id,p.name From projects p ";
            entityName = "Project: ";
        }
        try {
            connection = DriverManager.getConnection(Main.getURL(), Main.getUSER(), Main.getPASSWORD());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                String name = resultSet.getString("name");

                String result = String.format(" id = '%d' , name = '%s'", id, name);
                System.out.println(entityName + result);
            }
            connection.close();
            statement.close();
            resultSet.close();


        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void deleteEntity(T value, Long id) {
        String query = " ";
        if (value instanceof Developer) {
            query = String.format("DELETE FROM developers WHERE id = '%d'", id);
        } else if (value instanceof Customer) {
            query = String.format("DELETE FROM customers WHERE id = '%d'", id);
        } else if (value instanceof Project) {
            query = String.format("DELETE FROM projects WHERE id = '%d'", id);
            try {
                connection = DriverManager.getConnection(Main.getURL(), Main.getUSER(), Main.getPASSWORD());
                statement = connection.createStatement();
                statement.executeQuery(query);

                connection.close();
                statement.close();

            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }

    public void UpdateEntity(T value, Long idForSearch) {
        String query = " ";
        if (value instanceof Developer) {
            query = String.format("UPDATE developers Name = '%s', Gender = '%s', age = '%d', salary = '%d' WHERE developers_id = '%d'", ((Developer) value).getName(), ((Developer) value).getGenderOfDevelopers(), ((Developer) value).getAge(), ((Developer) value).getSalary(), idForSearch);
        } else if (value instanceof Customer) {
            query = String.format("UPDATE customers Name = '%s', email = '%s' WHERE customer_id = '%d'", ((Customer) value).getName(), ((Customer) value).getEmail(), idForSearch);
        } else if (value instanceof Project) {
            query = String.format("UPDATE projects Name = '%s', description = '%s', cost = '%d' WHERE project_id = '%d'", ((Project) value).getName(), ((Project) value).getDescription(), ((Project) value).getCost(), idForSearch);
        }

        try {
            connection = DriverManager.getConnection(Main.getURL(), Main.getUSER(), Main.getPASSWORD());
            statement = connection.createStatement();
            statement.executeQuery(query);

            connectionDB.closeConnection();
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
    }
}
