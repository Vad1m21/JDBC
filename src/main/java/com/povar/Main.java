
package com.povar;

import com.povar.domain.Developer;
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



    private static final DeveloperProjectService developerProjectService = new DeveloperProjectService();
    private static final DeveloperSkillService developerSkillService = new DeveloperSkillService();
    private static final GenericService<Developer> genericService = new GenericService<>();


    public static void main(String[] args) throws SQLException{

       // developerSkillService.findAllDevelopersByLanguage("java");

       // developerSkillService.findAllDevelopersByLevelOfLanguage("Junior");
        //developerProjectService.findSumOfSalaryAllDevelopersOnTheProject(2l);
          //  developerProjectService.findAllDevelopersOnTheProject(2l);
          // developerProjectService.findProjectAndAmountOfDevelopers();

        //genericService.addNewEntity(new Developer("test", GenderOfDevelopers.MALE,18,new BigDecimal("300000")));
       //genericService.getAllEntities(new Developer());
       // genericService.UpdateEntity(new Developer("Igor",GenderOfDevelopers.MALE,25,new BigDecimal("65000")),3l);


    }
}
