
package com.povar;

import com.povar.domain.Developer;
import com.povar.domain.Gender;
import com.povar.repository.CustomerDAO;
import com.povar.repository.DeveloperDAO;
import com.povar.service.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
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



    private static final DeveloperProjectService developerProjectService = new DeveloperProjectService();
    private static final DeveloperSkillService developerSkillService = new DeveloperSkillService();
    private static final CustomerService customerService = new CustomerService(new CustomerDAO());
    private static final DeveloperService developerService = new DeveloperService(new DeveloperDAO());

    public static void main(String[] args) throws SQLException{


       //developerSkillService.findAllDevelopersByLanguage("java");
       //developerSkillService.findAllDevelopersByLevelOfLanguage("Junior");
        //developerProjectService.findSumOfSalaryAllDevelopersOnTheProject(2l);
          //developerProjectService.findAllDevelopersOnTheProject(2l);
          //developerProjectService.findProjectAndAmountOfDevelopers();

        //developerService.addNewDeveloper(new Developer("Test", Gender.MALE, 19, new BigDecimal("1000")));
          //developerService.updateDeveloper(6l,new Developer("Test1",Gender.FEMALE,25,new BigDecimal("000")));


       //developerService.deleteDeveloper(12l);

        //System.out.println(developerService.getAllDevelopers());
    }
}
