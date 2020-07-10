package com.povar.service;

import com.povar.domain.Developer;
import com.povar.repository.DeveloperSkillDAO;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DeveloperSkillService {

    public List<Developer> findAllDevelopersByLanguage(String language){
        return new DeveloperSkillDAO().findAllDevelopersByLanguage(language);
    }

    public  List<Developer>  findAllDevelopersByLevelOfLanguage(String level){
        return  new DeveloperSkillDAO().findAllDevelopersByLevelOfLanguage(level);
    }


}
