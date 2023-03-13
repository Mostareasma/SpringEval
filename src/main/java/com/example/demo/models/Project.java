package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NamedQuery;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name = "saveWithNamedQuery", query = "INSERT INTO Project (id, title, description, user) VALUES (:project_id, :title, :description, :user)")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String description;

    @OneToMany(mappedBy = "project")
    private Set<Task> tasks;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user ;


}
