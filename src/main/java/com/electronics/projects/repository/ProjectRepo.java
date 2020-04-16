package com.electronics.projects.repository;

import com.electronics.projects.model.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepo extends CrudRepository<Project, Integer> {
    
    Project getById(Integer id);

    @Query("select p from Project p")
    List<Project> getAll();
}
