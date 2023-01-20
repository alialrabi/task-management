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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Organization extends Metadata {

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

    @Lob
    @Column(name = "icon")
    private byte[] icon;

    @Column(name = "icon_content_type")
    private String iconContentType;

    @OneToMany(mappedBy = "organization")
    private Set<Taskgroup> taskgroups = new HashSet<>();

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

    public Set<Taskgroup> getTaskgroups() {
        return this.taskgroups;
    }

    public void setTaskgroups(Set<Taskgroup> taskgroups) {
        this.taskgroups = taskgroups;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Organization)) {
            return false;
        }
        Organization organization = (Organization) o;
        return Objects.equals(id, organization.id) && Objects.equals(name, organization.name) && Objects.equals(description, organization.description)  && Objects.equals(icon, organization.icon) && Objects.equals(iconContentType, organization.iconContentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, icon, iconContentType);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", icon='" + getIcon() + "'" +
            ", iconContentType='" + getIconContentType() + "'" +
            "}";
    }

    
}
