package com.task.rest;


import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.service.TaskService;
import com.task.service.dto.TaskDTO;

@RestController
@RequestMapping("/api")
public class TaskResource {
	
	private TaskService taskService;
	
	public TaskResource(TaskService taskService) {
		this.taskService = taskService;
	}	
	
	@PostMapping("/tasks")
	public ResponseEntity<TaskDTO> saveTask(@Valid @RequestBody TaskDTO taskDTO){		
		TaskDTO newTaskDTO = taskService.save(taskDTO);	
		return new ResponseEntity<>(newTaskDTO, HttpStatus.OK);
	}
	
	@GetMapping("/task/{id}")
	public ResponseEntity<TaskDTO> getTask(@PathVariable Long id){
		TaskDTO taskDTO = taskService.getOne(id);	
		return new ResponseEntity<>(taskDTO, HttpStatus.OK);
	}

	@GetMapping("/tasks")
	public ResponseEntity<Page<TaskDTO>> getTasks(@RequestParam("page") int page,
	           @RequestParam("size") int size){
		Pageable pageable=PageRequest.of(page, size);		
		Page<TaskDTO> taskDTOs = taskService.getAll(pageable);	
		return new ResponseEntity<>(taskDTOs, HttpStatus.OK);
	}

}
