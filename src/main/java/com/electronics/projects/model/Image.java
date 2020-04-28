package com.electronics.projects.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @NotNull
    @Column(name = "image_name")
    @Size(max = 100, message = "Please rename image, max image name is 100 characters long")
    private String imageName;

    @Column(name = "url")
    @NotNull(message = "URL cannot be empty")
    @Size(max = 150, message = "URL must be no longer than 150 characters")
    private String url;

    @Column(name = "image_description")
    @NotNull(message = "Image description cannot be empty")
    @Size(max = 100, message = "Image description must be no longer than 100 characters")
    private String imageDescription;

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


    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", imageName='" + imageName + '\'' +
                ", url='" + url + '\'' +
                ", imageDescription='" + imageDescription + '\'' +
                '}';
    }
}
