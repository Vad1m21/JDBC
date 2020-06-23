package com.povar.repository;
import com.povar.Main;
import com.povar.domain.Developer;
import com.povar.domain.Project;
import com.povar.domain.ProjectDeveloper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;
import java.sql.*;
import java.util.*;
import java.util.Date;

@Data
@RequiredArgsConstructor
public class ProjectDeveloperDAO {



    Connection connection;
    Statement statement;
    ResultSet resultSet;

    String queryForSum = "select sum(salary) from projects_developers pd inner join projects p on pd.project_id = p.project_id inner join developers d on pd.developer_id = d.developers_id where p.project_id = ";
    String queryForListDevelopers = "select * from projects_developers pd inner join projects p on pd.project_id = p.project_id inner join developers d on pd.developer_id = d.developers_id where p.project_id = ";
    String queryForListOfProject = "select p.date, p.name, count(pd.developer_id) from projects p join projects_developers pd on p.project_id = pd.project_id group by pd.project_id";


    public List<ProjectDeveloper> FindProjectAndAmountOfDevelopers(){
            List<ProjectDeveloper> projectsDevelopers = new ArrayList<>();

        try {
             connection = DriverManager.getConnection(Main.getURL(),Main.getUSER(),Main.getPASSWORD());
             statement = connection.createStatement();
             resultSet = statement.executeQuery(queryForListOfProject);
             while(resultSet.next()){
                 Date date = resultSet.getDate("date");
                 String name = resultSet.getString("p.name");
                 Integer count = resultSet.getInt("count(pd.developer_id)");
                 projectsDevelopers.add(new ProjectDeveloper(date,name,count));
             }
            System.out.println(projectsDevelopers);
            connection.close();
            statement.close();
            resultSet.close();
        }

        catch (SQLException exception){
            exception.printStackTrace();
        }
        return projectsDevelopers;
    }


    public BigDecimal findSumOfSalaryAllDevelopersOnTheProject(){
            BigDecimal sumOfSalaryOnTheProject = new BigDecimal(0);

        try {
            connection = DriverManager.getConnection(Main.getURL(), Main.getUSER(), Main.getPASSWORD());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(createStatementForSumSalary());
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


    public List<Developer> findAllDevelopersOnTheProject(){
        List<Developer> developerList = new ArrayList<>();
        try {

            connection = DriverManager.getConnection(Main.getURL(), Main.getUSER(), Main.getPASSWORD());
            statement = connection.createStatement();
            resultSet = statement.executeQuery(createStatementForListOfDevelopers());
            while (resultSet.next()){
                Long developerId = resultSet.getLong("developer_id");
                String name = resultSet.getString("d.name");
                String gender = resultSet.getString("gender");
                Integer age = resultSet.getInt("age");
                BigDecimal salary = resultSet.getBigDecimal("salary");
                developerList.add(new Developer(developerId,name,gender,age,salary));
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



    private String createStatementForSumSalary(){
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder(queryForSum);


        System.out.print("Enter id of company which you want to calculate salary: ");

        Long id = scanner.nextLong();
        stringBuilder.append(id);


        return queryForSum = stringBuilder.toString();
    }


    private String createStatementForListOfDevelopers(){
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder(queryForListDevelopers);

        System.out.print("Enter id of company where you want to see list of developers: ");
        Long id = scanner.nextLong();
        stringBuilder.append(id);

        return queryForListDevelopers = stringBuilder.toString();
    }


}

