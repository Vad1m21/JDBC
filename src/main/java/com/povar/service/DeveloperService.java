package com.povar.service;

import com.povar.repository.DeveloperDAO;

public class DeveloperService {

    private DeveloperDAO developerDAO;


    public void addNewDeveloper(){
        new DeveloperDAO().addNewDeveloper();
    }
}
