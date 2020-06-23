package com.povar.repository;

import com.povar.Main;
import com.povar.domain.Developer;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeveloperSkillDAO {

    Connection connection;
    Statement statement;
    ResultSet resultSet;
    String queryForSkillDevelopers = " SELECT * FROM my_db.developers_skills ds inner join developers d on ds.developer_id = d.developers_id inner join skills s on ds.skill_id = s.Skills_id where s.name = \"";
    String queryForLevelOfLanguage =" SELECT * FROM my_db.developers_skills ds inner join developers d on ds.developer_id = d.developers_id inner join skills s on ds.skill_id = s.Skills_id  where s.level = \"";

    private String createStatementForLanguage(){
        Scanner scanner = new Scanner(System.in);
        StringBuilder  stringBuilder = new StringBuilder(queryForSkillDevelopers);

        System.out.print("Write language in which you want find developers: ");
        String language = scanner.nextLine();

        stringBuilder.append(language);
        stringBuilder.append("\"");

        return queryForSkillDevelopers = stringBuilder.toString();
    }

    private String createStatementForLevelOfSkill(){
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder(queryForLevelOfLanguage);

        System.out.println("Enter level of languages in which you would like to find developers:");
        String level = scanner.nextLine();
        stringBuilder.append(level);
        stringBuilder.append("\" ");
        stringBuilder.append("group by d.name");

        return queryForLevelOfLanguage = stringBuilder.toString();
    }

    public List<Developer> findAllDevelopersByLanguage(){
        List<Developer> developerList = new ArrayList<>();
        try{
            connection = DriverManager.getConnection(Main.getURL(),Main.getUSER(),Main.getPASSWORD());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(createStatementForLanguage());
            while (resultSet.next()){
                Long id = resultSet.getLong("developer_id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                Integer age = resultSet.getInt("age");
                BigDecimal salary = resultSet.getBigDecimal("salary");
                developerList.add(new Developer(id,name,gender,age,salary));
            }
            System.out.println(developerList);

            connection.close();
            statement.close();
            resultSet.close();
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }


        return developerList;
    }

    public List<Developer> findAllDevelopersByLevelOfLanguage(){
        List<Developer> developers = new ArrayList<>();
        try{
            connection = DriverManager.getConnection(Main.getURL(),Main.getUSER(),Main.getPASSWORD());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(createStatementForLevelOfSkill());
            while (resultSet.next()){
                Long id = resultSet.getLong("developer_id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                Integer age = resultSet.getInt("age");
                BigDecimal salary = resultSet.getBigDecimal("salary");
                developers.add(new Developer(id,name,gender,age,salary));
            }
            connection.close();
            statement.close();
            resultSet.close();
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }


        return null;
    }

}
