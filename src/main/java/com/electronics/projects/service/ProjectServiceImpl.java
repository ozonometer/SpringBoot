package com.electronics.projects.service;

import com.electronics.projects.model.Project;
import com.electronics.projects.repository.ProjectRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

    final ProjectRepo projectRepo;
    public final CloudStorageService cloud;

    public ProjectServiceImpl(ProjectRepo projectRepo, CloudStorageService cloud) {
        this.projectRepo = projectRepo;
        this.cloud = cloud;
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

    /**
     * Inserts new project into database
     * @param project Project object
     * @return saved project entity
     */
    @Override
    public Project createNew(Project project) {
        project.getProjectDescription().setProject(project);
        return projectRepo.save(project);
    }
}
