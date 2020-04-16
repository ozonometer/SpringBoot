package com.electronics.projects.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "project")
public class Project extends UpdatableEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotNull
    @Column(name = "name")
    @Size(min = 5, max = 20, message = "Name must be between 5 to 20 characters long")
    private String name;

    @NotNull
    @Column(name = "short_info")
    @Size(min = 5, max = 500, message = "Short info must be between 5 to 500 characters long")
    private String shortInfo;

    @OneToMany(mappedBy = "project")
    private List<ProjectDescription> projectDescription;
}
