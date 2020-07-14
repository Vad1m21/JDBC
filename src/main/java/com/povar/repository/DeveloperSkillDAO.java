package com.povar.repository;

import com.povar.Main;
import com.povar.domain.Developer;
import com.povar.domain.Gender;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DeveloperSkillDAO {

   private Connection connection;
   private Statement statement;
   private ResultSet resultSet;


    public List<Developer> findAllDevelopersByLanguage(String language){
        List<Developer> developerList = new ArrayList<>();
       String queryForSkillDevelopers = String.format(" SELECT * FROM my_db.developers_skills ds inner join developers d on ds.developer_id = d.developers_id inner join skills s on ds.skill_id = s.Skills_id where s.name = '%s' ", language);
        try{
            connection = DriverManager.getConnection(Main.getURL(),Main.getUSER(),Main.getPASSWORD());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryForSkillDevelopers);
            while (resultSet.next()){
                Long id = resultSet.getLong("developer_id");
                String name = resultSet.getString("name");
                Gender gender = Gender.valueOf(resultSet.getString("gender").toUpperCase());
                Integer age = resultSet.getInt("age");
                BigDecimal salary = resultSet.getBigDecimal("salary");
                developerList.add(new Developer(id,name, gender,age,salary));
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

    public List<Developer> findAllDevelopersByLevelOfLanguage(String level){
        List<Developer> developers = new ArrayList<>();
       String queryForLevelOfLanguage = String.format("SELECT * FROM my_db.developers_skills ds inner join developers d on ds.developer_id = d.developers_id inner join skills s on ds.skill_id = s.Skills_id  where s.level = '%s' group by d.developers_id",level);
        try{
            connection = DriverManager.getConnection(Main.getURL(),Main.getUSER(),Main.getPASSWORD());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryForLevelOfLanguage);
            while (resultSet.next()){
                Long id = resultSet.getLong("developer_id");
                String name = resultSet.getString("name");
                Gender gender = Gender.valueOf(resultSet.getString("gender").toUpperCase());
                Integer age = resultSet.getInt("age");
                BigDecimal salary = resultSet.getBigDecimal("salary");
                developers.add(new Developer(id,name, gender,age,salary));
            }
            System.out.println(developers);
            connection.close();
            statement.close();
            resultSet.close();
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }


        return developers;
    }


}
