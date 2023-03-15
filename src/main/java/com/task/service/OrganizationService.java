package com.task.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.task.model.Organization;
import com.task.service.dto.OrganizationDTO;

public interface OrganizationService {

    public Organization save(Organization organization);

    public Organization update(Organization organization);

    public Page<OrganizationDTO> getAll(Pageable pageable);

    public OrganizationDTO getOne(long id);

    public void delete(long id);
    
}
