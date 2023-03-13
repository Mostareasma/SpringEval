package com.example.demo.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String email;

    @OneToMany(mappedBy = "user")
    private Set<Project> projects;

}
