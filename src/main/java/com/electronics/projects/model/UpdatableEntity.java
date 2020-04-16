package com.electronics.projects.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@MappedSuperclass
public abstract class UpdatableEntity {

    @Column(name = "created", nullable = true, updatable = false, insertable = false)
    @NotNull(message = "Date create cannot be null")
    private Date created;

    @Column(name = "updated", insertable = false)
    @NotNull(message = "Date updated cannot be null")
    private Date updated;
}
