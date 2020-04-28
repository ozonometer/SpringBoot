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
    @Size(max = 100, message = "Please rename file, max image name is 100 characters long")
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", url='" + url + '\'' +
                ", fileDescription='" + fileDescription + '\'' +
                '}';
    }
}
