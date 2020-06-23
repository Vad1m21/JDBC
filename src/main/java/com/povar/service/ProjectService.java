package com.povar.service;

import com.povar.domain.Project;
import com.povar.repository.DeveloperDAO;
import com.povar.repository.ProjectDAO;

public class ProjectService {




    public void addNewProject(){ new ProjectDAO().addNewProject();
    }
}
