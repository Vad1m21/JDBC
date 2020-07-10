package com.povar.service;

import com.povar.domain.Developer;
import com.povar.domain.DeveloperProject;
import com.povar.repository.DeveloperProjectDAO;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class DeveloperProjectService {



    public BigDecimal findSumOfSalaryAllDevelopersOnTheProject(Long id) throws SQLException {
      return  new DeveloperProjectDAO().findSumOfSalaryAllDevelopersOnTheProject(id);
    }


    public List<Developer> findAllDevelopersOnTheProject(Long id) throws SQLException{
        return new DeveloperProjectDAO().findAllDevelopersOnTheProject(id);
    }

    public List<DeveloperProject> findProjectAndAmountOfDevelopers() throws SQLException{
       return new DeveloperProjectDAO().findProjectAndAmountOfDevelopers();
    }


}
