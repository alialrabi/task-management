package com.task.rest;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.task.service.TaskGroupService;
import com.task.service.dto.TaskgroupDTO;

@RestController
@RequestMapping("/api")
public class TaskgroupResource {
	
	private TaskGroupService taskGroupService;
	
	public TaskgroupResource(TaskGroupService taskGroupService) {
		this.taskGroupService = taskGroupService;
	}	
	
	@GetMapping("/taskgroup/{id}")
	public ResponseEntity<TaskgroupDTO> getTaskgroup(@PathVariable Long id){
		TaskgroupDTO taskgroupDTO = taskGroupService.getOne(id);
		return new ResponseEntity<>(taskgroupDTO, HttpStatus.OK);
	}

	@GetMapping("/taskgroups")
	public ResponseEntity<Page<TaskgroupDTO>> getTaskgroups(@RequestParam("page") int page,
	           @RequestParam("size") int size){
		Pageable pageable=PageRequest.of(page, size);		
		Page<TaskgroupDTO> taskgroupDTOs = taskGroupService.getAll(pageable);	
		return new ResponseEntity<>(taskgroupDTOs, HttpStatus.OK);
	}

	@GetMapping("/organization/taskgroups")
	public ResponseEntity<List<TaskgroupDTO>> getTaskgroupsByOrganization(@RequestParam("page") int page,
	           @RequestParam("size") int size,@RequestParam("organizationId")  long id){
		Pageable pageable=PageRequest.of(page, size);		
		List<TaskgroupDTO> taskgroupDTOs = taskGroupService.findByDomainAndOrganization(id);
		return new ResponseEntity<>(taskgroupDTOs, HttpStatus.OK);
	}

}
