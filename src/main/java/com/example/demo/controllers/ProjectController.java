package com.example.demo.controllers;

import com.example.demo.models.Project;
import com.example.demo.repositories.TaskRepository;
import com.example.demo.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> searchProjects(@RequestParam String title) {
        List<Project> projects = projectService.search(title);
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Object> saveProject(@PathVariable Long userId, @RequestBody Project project) {
        try {
            Project newProject = projectService.saveWithNamedQuery(project.getId(), project.getTitle(), project.getDescription(), userId);
            return new ResponseEntity<>(newProject, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
