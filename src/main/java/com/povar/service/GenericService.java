package com.povar.service;

import com.povar.domain.GenderOfDevelopers;
import com.povar.repository.GenericDAO;

public class GenericService<T> {

    public void addNewEntity(T value){
        new GenericDAO<T>().addNewEntity(value);
    }

    public  void getAllEntities(T value){
        new GenericDAO<T>().getAllEntities(value);
    }

    public void deleteEntity(T value,Long id){
        new GenericDAO<T>().deleteEntity(value,id);
    }

    public void UpdateEntity(T value, Long idForSearch){
        new GenericDAO<T>().UpdateEntity(value,idForSearch);
    }
}
