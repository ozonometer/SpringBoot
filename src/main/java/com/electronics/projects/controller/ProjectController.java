package com.electronics.projects.controller;

import com.electronics.projects.model.Project;
import com.electronics.projects.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/add")
public class ProjectController {

    final
    ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/new")
    public ResponseEntity<Project> createNewProject(@RequestBody @Valid Project project) throws ServletException, IOException {

        Project projectSaved = projectService.createNew(project);
        return new ResponseEntity<>(projectSaved, HttpStatus.OK);
    }
}
