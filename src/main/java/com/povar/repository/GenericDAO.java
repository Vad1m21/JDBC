package com.povar.repository;

import com.povar.Main;


import com.povar.domain.Gender;
import com.sun.jdi.InternalException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Data
@RequiredArgsConstructor
@Slf4j
public abstract class GenericDAO<T,ID> {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;


    public List<T> getAllEntities() {
        String query = "SELECT * FROM " + getTableName();
        try {
            connection = DriverManager.getConnection(Main.getURL(), Main.getUSER(), Main.getPASSWORD());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            return convertToList(resultSet);

        } catch (SQLException exception) {
            log.error("Error occurred while getting all entities from table ={}.Cause: {}", getTableName(), exception.getMessage());
            throw new InternalException(String.valueOf(exception));
        }

    }

    public void deleteEntity(Long id) {
        String query = "DELETE FROM `" + getTableName() + "` WHERE " + getColumnId() + " = " + id;
        try {
            connection = DriverManager.getConnection(Main.getURL(), Main.getUSER(), Main.getPASSWORD());
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException exception) {
            log.error("Error occurred while delete entity from table ={}.Cause: {}", getTableName(), exception.getMessage());
            throw new InternalException(String.valueOf(exception));
        }
    }

    public void addNewEntity(T value) {
        String query = createQuery(value);
        try {
            connection = DriverManager.getConnection(Main.getURL(), Main.getUSER(), Main.getPASSWORD());
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException exception) {
            log.error("Error occurred while add new  entity to table = {} . Cause: {}", getTableName(), exception.getMessage());
            throw new InternalException(String.valueOf(exception));
        }
    }

    public void updateEntity(Long id, T value) {
        String query = createQueryForUpdate(id, value);
        try {
            connection = DriverManager.getConnection(Main.getURL(), Main.getUSER(), Main.getPASSWORD());
            statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (SQLException exception) {
            log.error("Error occurred while update entity to table = {} . Cause: {}", getTableName(), exception.getMessage());
            throw new InternalException(String.valueOf(exception));
        }
    }

    protected abstract String createQueryForUpdate(Long id, T value);

    protected abstract String getTableName();

    protected abstract String createQuery(T value);

    protected abstract List<T> convertToList(ResultSet resultSet);

    protected abstract String getColumnId();
}

