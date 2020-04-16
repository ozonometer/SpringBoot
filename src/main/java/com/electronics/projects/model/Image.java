package com.electronics.projects.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "image")
public class Image extends UpdatableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "project_id")
    @NotNull(message = "Project Id cannot be empty")
    private Integer projectId;

    @NotNull
    @Column(name = "image_name")
    @Size(min = 5, max = 20, message = "Image name must be between 5 to 20 characters long")
    private String imageName;

    @Column(name = "url")
    @NotNull(message = "URL cannot be empty")
    @Size(max = 150, message = "URL must be no longer than 150 characters")
    private String url;
}
