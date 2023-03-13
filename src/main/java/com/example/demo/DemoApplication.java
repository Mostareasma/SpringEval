package com.example.demo;

import com.example.demo.models.Project;
import com.example.demo.models.Task;
import com.example.demo.models.User;
import com.example.demo.repositories.ProjectRepository;
import com.example.demo.repositories.TaskRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private TaskRepository taskRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Create a user
		User user = new User();
		user.setName("John Doe");
		user.setEmail("johndoe@example.com");
		user = userRepository.save(user);
		// Create a user
		User user1 = new User();
		user1.setName("Joe dalton");
		user1.setEmail("joedalton@example.com");
		user1 = userRepository.save(user1);

		// Create a project
		Project project = new Project();
		project.setTitle("Project 1");
		project.setDescription("This is project 1");
		project.setUser(user);
		project = projectRepository.save(project);

		// Create a task
		Task task = new Task();
		task.setTitle("Task 1");
		task.setDescription("This is task 1 for project 1");
		task.setProject(project);
		taskRepository.save(task);
	}
}
