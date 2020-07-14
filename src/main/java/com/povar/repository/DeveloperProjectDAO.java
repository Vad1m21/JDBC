package com.povar.repository;

import com.povar.Main;

import com.povar.domain.Developer;
import com.povar.domain.DeveloperProject;
import com.povar.domain.Gender;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeveloperProjectDAO {

   private Connection connection;
   private Statement statement;
   private ResultSet resultSet;


   private final String queryForListOfProject = "select p.date, p.name, count(pd.developer_id) from projects p join developers_projects pd on p.project_id = pd.project_id group by pd.project_id";


    public List<DeveloperProject> findProjectAndAmountOfDevelopers(){
        List<DeveloperProject> projectsDevelopers = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(Main.getURL(),Main.getUSER(),Main.getPASSWORD());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryForListOfProject);

            while(resultSet.next()){
                Date date = resultSet.getDate("date");
                String name = resultSet.getString("p.name");
                Integer count = resultSet.getInt("count(pd.developer_id)");
                projectsDevelopers.add(new DeveloperProject(date,name,count));
            }
            System.out.println(projectsDevelopers);
            connection.close();
        }

        catch (SQLException exception){
            exception.printStackTrace();
        }
        return projectsDevelopers;
    }


    public BigDecimal findSumOfSalaryAllDevelopersOnTheProject(Long id){
        BigDecimal sumOfSalaryOnTheProject = new BigDecimal(0);
         String queryForSum = String.format("select sum(salary) from developers_projects pd inner join projects p on pd.project_id = p.project_id inner join developers d on pd.developer_id = d.developers_id where p.project_id = %d ",id);

        try {
            connection = DriverManager.getConnection(Main.getURL(), Main.getUSER(), Main.getPASSWORD());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryForSum);
            while (resultSet.next()){
                sumOfSalaryOnTheProject = resultSet.getBigDecimal("sum(salary)");
            }
            System.out.println(sumOfSalaryOnTheProject);
            connection.close();
            statement.close();
            resultSet.close();
        }
        catch (SQLException exception){
            exception.printStackTrace();
        }

        return sumOfSalaryOnTheProject;
    }


     public List<Developer> findAllDevelopersOnTheProject(Long id){
        List<Developer> developerList = new ArrayList<>();
        String queryForListDevelopers = String.format("select * from developers_projects pd inner join projects p on pd.project_id = p.project_id inner join developers d on pd.developer_id = d.developers_id where p.project_id = %d",id);
        try {

            connection = DriverManager.getConnection(Main.getURL(), Main.getUSER(), Main.getPASSWORD());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryForListDevelopers);
            while (resultSet.next()){
                Long developerId = resultSet.getLong("developer_id");
                String name = resultSet.getString("d.name");
                Gender gender = Gender.valueOf(resultSet.getString("gender").toUpperCase());
                Integer age = resultSet.getInt("age");
                BigDecimal salary = resultSet.getBigDecimal("salary");
                developerList.add(new Developer(developerId,name, gender,age,salary));
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


}
