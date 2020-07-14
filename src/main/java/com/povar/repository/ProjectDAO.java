package com.povar.repository;

import com.povar.domain.Project;
import lombok.extern.slf4j.Slf4j;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ProjectDAO extends GenericDAO<Project,Long> {

    @Override
    protected String createQueryForUpdate(Long id, Project project) {
        return String.format("UPDATE `my_db`.`projects` SET name = '%s', description = '%s', cost = '%d' WHERE project_id = '%d'", project.getName(), project.getDescription(), project.getCost(), id);
    }

    @Override
    protected String getTableName() {
        return "projects";
    }

    @Override
    protected String createQuery(Project project) {
        return String.format(" INSERT INTO `my_db`.`projects` (`name`, `description`, `date`, 'cost') VALUES ('%s','%s','%t','%d'",  project.getName(), project.getDescription(), project.getDate(), project.getCost());
    }

    @Override
    protected List<Project> convertToList(ResultSet resultSet) {
        List<Project> projects = new ArrayList<>();
        try {
            while(resultSet.next()){
                Project project = new Project();
                project.setId(resultSet.getLong("project_id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setDate(resultSet.getDate("date"));
                project.setCost(resultSet.getInt("cost"));
                projects.add(project);

            }
        }catch (SQLException exception){
            log.error("Error occurred while converting result set to list.Cause: {}",exception.getMessage());
        }

        return projects;
    }

    @Override
    protected String getColumnId() {
        return "project_id";
    }
}
