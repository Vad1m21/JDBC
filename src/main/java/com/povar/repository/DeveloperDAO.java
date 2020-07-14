package com.povar.repository;

import com.povar.domain.Developer;
import com.povar.domain.Gender;
import lombok.extern.slf4j.Slf4j;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class DeveloperDAO extends GenericDAO<Developer,Long> {


    @Override
    protected String createQueryForUpdate(Long id, Developer developer) {
        return String.format("UPDATE `my_db`.`developers` SET name = '%s', Gender = '%s', age = '%d', salary = '%s' WHERE developers_id = '%d'", developer.getName(), developer.getGender(), developer.getAge(), developer.getSalary(), id);
    }

    @Override
    protected String getTableName() {
        return "developers";
    }

    @Override
    protected String createQuery(Developer developer) {
        return String.format("INSERT INTO `my_db`.`developers` ( `name`, `gender`, `age`,`salary`) VALUES ( '%s','%s', '%d', '%s')", developer.getName(), developer.getGender(),developer.getAge(), developer.getSalary());
    }


    @Override
    protected List<Developer> convertToList(ResultSet resultSet) {
        List<Developer> developers = new ArrayList<>();
        try {
            while (resultSet.next()){
                Developer developer = new Developer();
                developer.setId(resultSet.getLong("developers_id"));
                developer.setName(resultSet.getString("name"));
                developer.setGender(Gender.valueOf(resultSet.getString("gender").toUpperCase()));
                developer.setAge(resultSet.getInt("age"));
                developer.setSalary(resultSet.getBigDecimal("salary"));
                developers.add(developer);
            }
        }catch (SQLException exception){
            log.error("Error occurred while converting result set to list. Cause: {}",exception.getMessage());
        }

        return developers;
    }

    @Override
    protected String getColumnId() {
        return "developers_id";
    }
}
