package com.povar.service;

import com.povar.domain.Developer;
import com.povar.repository.ProjectDeveloperDAO;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class ProjectDeveloperService {

    private ProjectDeveloperDAO projectDeveloperDAO;

    public BigDecimal findSumOfSalaryAllDevelopersOnTheProject() throws SQLException {
      return  new ProjectDeveloperDAO().findSumOfSalaryAllDevelopersOnTheProject();
    }


    public List<Developer> findAllDevelopersOnTheProject() throws SQLException{
        return new ProjectDeveloperDAO().findAllDevelopersOnTheProject();
    }

    public void FindProjectAndAmountOfDevelopers(){
        new ProjectDeveloperDAO().FindProjectAndAmountOfDevelopers();
    }
}
