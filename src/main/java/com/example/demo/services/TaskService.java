package com.example.demo.services;

import com.example.demo.models.Project;
import com.example.demo.models.Task;
import com.example.demo.repositories.ProjectRepository;
import com.example.demo.repositories.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ProjectRepository projectRepository;

    public List<Task> search(String title) {
        return taskRepository.findByTitleContainsIgnoreCaseOrderById(title);
    }

    public void deleteTasksByProjectId(Long projectId) {
        taskRepository.deleteByProjectId(projectId);
    }
    public Task addTaskToProject(Long projectId, Task task) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new EntityNotFoundException("Project not found"));
        task.setProject(project);
        return taskRepository.save(task);
    }

}
