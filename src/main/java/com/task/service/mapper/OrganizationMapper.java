package com.task.service.mapper;
import org.mapstruct.*;

import com.task.model.Organization;
import com.task.service.dto.OrganizationDTO;

@Mapper(componentModel = "spring")
public interface OrganizationMapper extends EntityMapper<OrganizationDTO, Organization>{
    
    OrganizationDTO toDto(Organization organization);
}
