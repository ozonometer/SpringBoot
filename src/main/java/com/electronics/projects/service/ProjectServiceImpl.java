package com.electronics.projects.service;

import com.electronics.projects.model.Project;
import com.electronics.projects.repository.ProjectRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{
    
    final ProjectRepo projectRepo;

    public ProjectServiceImpl(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepo.getAll();
    }

    @Override
    public Project getById(Integer id) {
        return projectRepo.getById(id);
    }

    @Override
    public Project saveOrUpdate(Project project) {
        return projectRepo.save(project);
    }
}
