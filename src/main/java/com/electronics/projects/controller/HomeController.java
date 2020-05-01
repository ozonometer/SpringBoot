package com.electronics.projects.controller;

import com.electronics.projects.model.Project;
import com.electronics.projects.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    final
    ProjectService projectService;

    public HomeController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getProjects() {
        List<Project> projects = projectService.getAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @PostMapping(path = "/project", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Project> addMember(@RequestBody @Valid Project project) {
        Project savedProject =  projectService.saveOrUpdate(project);
        return new ResponseEntity<>(savedProject, HttpStatus.OK);
    }
}
