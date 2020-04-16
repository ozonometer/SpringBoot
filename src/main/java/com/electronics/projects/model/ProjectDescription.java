package com.electronics.projects.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "project_description")
public class ProjectDescription extends UpdatableEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne( cascade = { CascadeType.ALL } )
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "text")
    @NotNull(message = "Text cannot be null")
    private String text;
    
    
}
