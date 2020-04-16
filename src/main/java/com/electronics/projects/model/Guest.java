package com.electronics.projects.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "guest")
public class Guest extends UpdatableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Column(name = "guest_name")
    @Size(min = 5, message = "Guest Name must be between 5 to 20 characters long")
    private String guestName;

    @Column(name = "first_name")
    @Size(min = 5, max = 20, message = "First Name must be between 5 to 20 characters long")
    private String firstName;
    
    @Column(name = "last_name")
    @Size(min = 5, max = 20, message = "Last Name must be between 5 to 20 characters long")
    private String lastName;

    @Column(name = "age")
    private Integer age;
    
    
}
