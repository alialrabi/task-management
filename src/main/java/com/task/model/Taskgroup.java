package com.task.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Taskgroup extends Metadata {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 3, max = 100)
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Size(max = 255)
    @Column(name = "description", length = 255)
    private String description;

    @NotNull
    @Column(name = "position", nullable = false)
    private Integer position;

    @Lob
    @Column(name = "icon")
    private byte[] icon;

    @Column(name = "icon_content_type")
    private String iconContentType;

    @ManyToOne(optional = false)
    private Organization organization;

    @OneToMany(mappedBy = "taskgroup")
    @JsonIgnoreProperties(
        value = {
            "taskgroup",
        },
        allowSetters = true
    )
    private Set<Task> task = new HashSet<>();

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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPosition() {
        return this.position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public byte[] getIcon() {
        return this.icon;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }

    public String getIconContentType() {
        return this.iconContentType;
    }

    public void setIconContentType(String iconContentType) {
        this.iconContentType = iconContentType;
    }

    public Organization getOrganization() {
        return this.organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Set<Task> getTask() {
        return this.task;
    }

    public void setTask(Set<Task> task) {
        this.task = task;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Taskgroup)) {
            return false;
        }
        Taskgroup taskgroup = (Taskgroup) o;
        return Objects.equals(id, taskgroup.id) && Objects.equals(name, taskgroup.name) && Objects.equals(description, taskgroup.description) && Objects.equals(position, taskgroup.position) && Objects.equals(icon, taskgroup.icon) && Objects.equals(iconContentType, taskgroup.iconContentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, position, icon, iconContentType);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", position='" + getPosition() + "'" +
            ", icon='" + getIcon() + "'" +
            ", iconContentType='" + getIconContentType() + "'" +
            "}";
    }

    
}
