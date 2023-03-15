package com.task.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.task.exception.OrganizationNotFoundException;
import com.task.exception.TaskNotFoundException;
import com.task.model.Organization;
import com.task.repository.OrganizationRepository;
import com.task.service.OrganizationService;
import com.task.service.dto.OrganizationDTO;
import com.task.service.mapper.OrganizationMapper;

@Service
public class OrganizationServiceImpl implements OrganizationService{

    private final OrganizationRepository organizationRepository;

    private final OrganizationMapper organizationMapper;
    
    public OrganizationServiceImpl(OrganizationRepository organizationRepository, OrganizationMapper organizationMapper) {
        this.organizationRepository = organizationRepository;
        this.organizationMapper = organizationMapper;
    } 

    @Override
    public Organization save(Organization organization) {
        return organizationRepository.save(organization);
    }

    @Override
    public Organization update(Organization organization) {
        return organizationRepository.save(organization);
    }

    @Override
    @Cacheable(value = "taskDto")
    public Page<OrganizationDTO> getAll(Pageable pageable) {
        return organizationRepository.findAll(pageable).map(organizationMapper::toDto);
    }
    
    @Override
    @Cacheable(value = "taskDto" ,key = "#id")
    public OrganizationDTO getOne(long id) {
        OrganizationDTO  organizationDTO= organizationRepository.findById(id).map(organizationMapper::toDto).orElseThrow(() -> 
           new OrganizationNotFoundException("Organization not found"));
        return organizationDTO;
    }

    @Override
    public void delete(long id) {
        organizationRepository.deleteById(id);        
    }
    
}
