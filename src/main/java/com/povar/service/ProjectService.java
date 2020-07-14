package com.povar.service;

import com.povar.domain.Developer;
import com.povar.domain.Project;
import com.povar.repository.ProjectDAO;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProjectService {

    private final ProjectDAO projectDAO;

    public List<Project> getAllProjects(){
        return projectDAO.getAllEntities();
    }

    public void deleteProject(Long id){
        projectDAO.deleteEntity(id);
    }

    public void addNewProject(Project project){
        projectDAO.addNewEntity(project);
    }

    public void updateProject(Long id,Project project){
        projectDAO.updateEntity(id, project);
    }
}
