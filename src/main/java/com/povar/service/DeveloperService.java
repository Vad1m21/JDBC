package com.povar.service;

import com.povar.domain.Developer;
import com.povar.repository.DeveloperDAO;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
public class DeveloperService {

    private final DeveloperDAO developerDAO;

    public List<Developer> getAllDevelopers(){
        return developerDAO.getAllEntities();
    }

    public void deleteDeveloper(Long id){
        developerDAO.deleteEntity(id);
    }

    public void addNewDeveloper(Developer developer){
        developerDAO.addNewEntity(developer);
    }

    public void updateDeveloper(Long id,Developer developer){
        developerDAO.updateEntity(id, developer);
    }
}
