package com.electronics.projects.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "file")
public class File extends UpdatableEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Column(name = "file_name")
    @Size(min = 5, max = 20, message = "File name must be between 5 to 20 characters long")
    private String fileName;

    @Column(name = "url")
    @NotNull(message = "URL cannot be empty")
    @Size(max = 150, message = "URL must be no longer than 150 characters")
    private String url;

    @Column(name = "file_description")
    @NotNull(message = "File description cannot be empty")
    @Size(max = 100, message = "File description must be no longer than 100 characters")
    private String fileDescription;

    @ManyToOne( cascade = { CascadeType.ALL } )
    @JoinColumn(name = "project_id")
    @JsonIgnore
    private Project project;
}
