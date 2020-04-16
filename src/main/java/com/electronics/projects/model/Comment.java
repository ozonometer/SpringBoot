package com.electronics.projects.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "comment")
public class Comment extends UpdatableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "project_id")
    @NotNull(message = "Project Id cannot be empty")
    private Integer projectId;

    @NotNull
    @Column(name = "guest_name")
    @Size(min = 5, max = 20, message = "Guest name must be between 5 to 20 characters long")
    private String guestName;
    
    @Column(name = "comment_text")
    @NotNull(message = "Comment text cannot be empty")
    private String commentText;
}
