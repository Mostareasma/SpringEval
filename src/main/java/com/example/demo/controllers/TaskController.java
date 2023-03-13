package com.example.demo.controllers;

import com.example.demo.models.Task;
import com.example.demo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> searchTasks(@RequestParam String title) {
        List<Task> tasks = taskService.search(title);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping("/{projectId}")
    public ResponseEntity<Task> addTaskToProject(@PathVariable Long projectId, @RequestBody Task task) {
        Task newTask = taskService.addTaskToProject(projectId, task);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }


    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> deleteTasksByProjectId(@PathVariable Long projectId) {
        taskService.deleteTasksByProjectId(projectId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
