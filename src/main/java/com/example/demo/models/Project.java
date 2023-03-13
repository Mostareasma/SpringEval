package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
