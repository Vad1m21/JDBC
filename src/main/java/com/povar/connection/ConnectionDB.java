package com.povar.connection;

import com.povar.Main;

import java.sql.*;

public class ConnectionDB {

    private Connection connection;
    private Statement statement;


    public void ConnectionToDBWithExecuteUpdate(String query){
        try {
            connection = DriverManager.getConnection(Main.getURL(),Main.getUSER(),Main.getPASSWORD());
            statement = connection.createStatement();
            statement.executeUpdate(query);
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
    }

   /* public ResultSet ConnectionToDBWithExecuteQuery(String query,Connection connection,Statement statement,ResultSet resultSet){
        try {
            connection = DriverManager.getConnection(Main.getURL(),Main.getUSER(),Main.getPASSWORD());
            statement = connection.createStatement();
            resultSet =  statement.executeQuery(query);
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }
        return resultSet;
    }


*/ /// вертає NullPointerException


    public void closeConnection(){
        try {
            connection.close();
            statement.close();
        }catch (SQLException exception){
            exception.printStackTrace();
        }

    }

}
