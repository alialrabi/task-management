package com.task.model;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Taskstatus extends Metadata {
   
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 3, max = 100)
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @NotNull
    @Size(min = 3, max = 25)
    @Column(name = "nameshort", length = 25, nullable = false)
    private String nameshort;

    @Size(max = 255)
    @Column(name = "description", length = 255)
    private String description;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameshort() {
        return this.nameshort;
    }

    public void setNameshort(String nameshort) {
        this.nameshort = nameshort;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Taskstatus)) {
            return false;
        }
        Taskstatus taskstatus = (Taskstatus) o;
        return Objects.equals(id, taskstatus.id) && Objects.equals(name, taskstatus.name) && Objects.equals(nameshort, taskstatus.nameshort) && Objects.equals(description, taskstatus.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nameshort, description);
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", nameshort='" + getNameshort() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }

}
