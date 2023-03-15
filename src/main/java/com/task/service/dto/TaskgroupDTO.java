package com.task.service.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.task.model.Metadata;

public class TaskgroupDTO extends Metadata {
    
    private Long id;

    private String name;

    private String description;

    private byte[] icon;

    private String iconContentType;

    private Set<TaskDTO> taskgroupTasks = new HashSet<>();

    public TaskgroupDTO(Long id, String name, byte[] icon) {
        this.id=id;
        this.name=name;
        this.icon=icon;
    }

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

    public Set<TaskDTO> getTaskgroupTasks() {
        return this.taskgroupTasks;
    }

    public void setTaskgroupTasks(Set<TaskDTO> taskgroupTasks) {
        this.taskgroupTasks = taskgroupTasks;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TaskgroupDTO)) {
            return false;
        }
        TaskgroupDTO taskgroupDTO = (TaskgroupDTO) o;
        return Objects.equals(id, taskgroupDTO.id) && Objects.equals(name, taskgroupDTO.name) && Objects.equals(description, taskgroupDTO.description) && Objects.equals(icon, taskgroupDTO.icon) && Objects.equals(iconContentType, taskgroupDTO.iconContentType);
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
