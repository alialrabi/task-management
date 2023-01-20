package com.task.service.dto;

import java.util.Objects;

import com.task.model.Metadata;

public class OrganizationDTO extends Metadata {
    
    private Long id;

    private String name;
  
    private String description;

    private byte[] icon;

    private String iconContentType;

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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrganizationDTO)) {
            return false;
        }
        OrganizationDTO organizationDTO = (OrganizationDTO) o;
        return Objects.equals(id, organizationDTO.id) && Objects.equals(name, organizationDTO.name) && Objects.equals(description, organizationDTO.description) && Objects.equals(icon, organizationDTO.icon) && Objects.equals(iconContentType, organizationDTO.iconContentType);
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
