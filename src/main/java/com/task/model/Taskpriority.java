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
public class Taskpriority extends Metadata {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 3, max = 25)
    @Column(name = "name", length = 25, nullable = false)
    private String name;

    @NotNull
    @Column(name = "position", nullable = false)
    private Integer position;


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

    public Integer getPosition() {
        return this.position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Taskpriority)) {
            return false;
        }
        Taskpriority taskpriority = (Taskpriority) o;
        return Objects.equals(id, taskpriority.id) && Objects.equals(name, taskpriority.name) && Objects.equals(position, taskpriority.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, position);
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", position='" + getPosition() + "'" +
            "}";
    }

}
