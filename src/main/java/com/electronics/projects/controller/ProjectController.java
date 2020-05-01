package com.electronics.projects.controller;

import com.electronics.projects.model.Project;
import com.electronics.projects.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/project")
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

    @Transactional(readOnly = true)
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Project> getProject(@PathVariable("id") int id) {
        Project project = projectService.getById(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }
}
