package com.task.rest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.service.OrganizationService;
import com.task.service.dto.OrganizationDTO;

@RestController
@RequestMapping("/api")
public class OrganizationResource {
	
	private OrganizationService organizationService;
	
	public OrganizationResource(OrganizationService organizationService) {
		this.organizationService = organizationService;
	}	
	
	@GetMapping("/organization/{id}")
	public ResponseEntity<OrganizationDTO> getOrganizations(@PathVariable Long id){
		OrganizationDTO organizationDTO = organizationService.getOne(id);	
		return new ResponseEntity<>(organizationDTO, HttpStatus.OK);
	}

	@GetMapping("/organizations")
	public ResponseEntity<Page<OrganizationDTO>> getTasks(
		       // @RequestParam("page") int page,
	          // @RequestParam("size") int size
			   ){
		Pageable pageable=PageRequest.of(0, 10);		
		Page<OrganizationDTO> organizationDTOs = organizationService.getAll(pageable);	
		return new ResponseEntity<>(organizationDTOs, HttpStatus.OK);
	}

}
