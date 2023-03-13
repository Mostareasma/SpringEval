package com.example.demo.controllers;

import com.example.demo.models.Project;
import com.example.demo.models.User;
import com.example.demo.repositories.TaskRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.ProjectService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<Project>> searchProjects(@RequestParam String title) {
        List<Project> projects = projectService.search(title);
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }
    @PostMapping("/{userId}")
    @Transactional
    public void saveProjectWithNamedQuery(@RequestBody Project project, @PathVariable Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        project.setUser(user);
        entityManager.merge(project);
    }


}
