package com.example.demo.repositories;

import com.example.demo.models.Project;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByTitleContainsIgnoreCaseOrderById(String title);

    @Query(value = "INSERT into Project (id, title, description, user_id) values (:project_id, :title, :description, :user_id)", nativeQuery = true)
    Project saveWithNamedQuery(@Param("project_id") Long projectId, @Param("title") String title, @Param("description") String description, @Param("user_id") Long userId);

}
