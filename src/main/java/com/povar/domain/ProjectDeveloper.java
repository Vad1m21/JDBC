package com.povar.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data

public class ProjectDeveloper {
    Date date;
    String name;
    Integer amountOfDevelopers;

    public ProjectDeveloper(  Date date, String name,Integer amountOfDevelopers) {
        this.date = date;
        this.name = name;
        this.amountOfDevelopers = amountOfDevelopers;
    }

}
