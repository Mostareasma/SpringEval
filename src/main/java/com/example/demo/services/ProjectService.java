package com.example.demo.services;

import com.example.demo.models.Project;
import com.example.demo.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {


    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> search(String title) {
        return projectRepository.findByTitleContainsIgnoreCaseOrderById(title);
    }
    public Project saveWithNamedQuery(Long id, String title, String description, Long userId) {
        return projectRepository.saveWithNamedQuery(id, title, description, userId);
    }

}
