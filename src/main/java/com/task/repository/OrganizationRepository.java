package com.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.model.Organization;


public interface OrganizationRepository extends JpaRepository<Organization, Long>{
    
}
