package com.electronics.projects.service;

import com.electronics.projects.model.Project;

import java.util.List;

public interface ProjectService {

    List<Project> getAllProjects();

    Project getById(Integer id);

    Project saveOrUpdate(Project project);

    Project createNew(Project project);
}
