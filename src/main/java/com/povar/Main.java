package com.povar;

import com.povar.service.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import java.sql.SQLException;


@Data
@RequiredArgsConstructor
public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/my_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static String getURL() {
        return URL;
    }

    public static String getUSER() {
        return USER;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }



    private static final ProjectDeveloperService projectDeveloperService = new ProjectDeveloperService();
    private static final DeveloperSkillService developerSkillService = new DeveloperSkillService();
    private static final DeveloperService developerService = new DeveloperService();
    private static final ProjectService projectService = new ProjectService();
    private static final CustomerService customerService = new CustomerService();



    public static void main(String[] args) throws SQLException{

       //BigDecimal sumOfSalary = projectDeveloperService.findSumOfSalaryAllDevelopersOnTheProject();

        //List<Developer> developerList = projectDeveloperService.findAllDevelopersOnTheProject();

        //List<Developer> developers = developerSkillService.findAllDevelopersByLanguage();

        //List<Developer> developerList = developerSkillService.findAllDevelopersByLevelOfLanguage();

        //projectDeveloperService.FindProjectAndAmountOfDevelopers();

        // developerService.addNewDeveloper();

        //projectService.addNewProject();

        //customerService.addNewCustomer();

    }
}
