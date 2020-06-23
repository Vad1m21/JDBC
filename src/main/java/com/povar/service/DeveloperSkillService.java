package com.povar.service;

import com.povar.domain.Developer;
import com.povar.repository.DeveloperSkillDAO;

import java.util.List;

public class DeveloperSkillService {

    private DeveloperSkillDAO developerSkillDAO;

    public List<Developer> findAllDevelopersByLanguage(){
        return new DeveloperSkillDAO().findAllDevelopersByLanguage();
    }

    public  List<Developer>  findAllDevelopersByLevelOfLanguage(){
        return  new DeveloperSkillDAO().findAllDevelopersByLevelOfLanguage();
    }
}
