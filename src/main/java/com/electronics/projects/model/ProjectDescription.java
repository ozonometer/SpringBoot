package com.electronics.projects.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToOne( cascade = { CascadeType.ALL } )
    @JoinColumn(name = "project_id")
    @JsonIgnore
    private Project project;

    @Column(name = "text")
    @NotNull(message = "Text cannot be null")
    private String text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "ProjectDescription{" +
                "id=" + id +
                ", project=" + project.getName() +
                ", text='" + text + '\'' +
                '}';
    }
}
