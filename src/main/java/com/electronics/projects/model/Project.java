package com.electronics.projects.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
@Table(name = "project")
public class Project extends UpdatableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "Project Name description cannot be empty")
    @Column(name = "name")
    @Size(min = 5, max = 20, message = "Project Name must be between 5 to 20 characters long")
    private String name;

    @NotNull(message = "Short description cannot be empty")
    @Column(name = "short_info")
    @Size(min = 5, max = 500, message = "Short description must be between 5 to 500 characters long")
    private String shortInfo;

    @Valid
    @OneToOne(mappedBy = "project", cascade = { CascadeType.ALL})
    private ProjectDescription projectDescription;

    @Valid
    @NotEmpty(message = "Please add at least one image")
    @OneToMany(mappedBy = "project", cascade = { CascadeType.ALL})
    private List<Image> images;

    @OneToMany(mappedBy = "project", cascade = { CascadeType.ALL})
    private List<File> files;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortInfo() {
        return shortInfo;
    }

    public void setShortInfo(String shortInfo) {
        this.shortInfo = shortInfo;
    }

    public ProjectDescription getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(ProjectDescription projectDescription) {
        this.projectDescription = projectDescription;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortInfo='" + shortInfo + '\'' +
                ", projectDescription=" + projectDescription.getText() +
                ", images=" + images +
                ", files=" + files +
                '}';
    }
}
