package com.task.rest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.hamcrest.Matchers.is;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.model.Task;
import com.task.security.jwt.JwtTokenUtil;
import com.task.service.OrganizationService;
import com.task.service.TaskGroupService;
import com.task.service.TaskService;
import com.task.service.UserService;
import com.task.service.dto.TaskDTO;
import com.task.service.mapper.TaskMapper;

@WebMvcTest(controllers = TaskResource.class)
@WithMockUser
public class TaskResourceTest {
	
	private String name = "task one";

	private String description = "task one";

    private Boolean isbillable = true;

    private Long progress = 5l;

	private Integer position = 5;

	private String createdBy = "admin";

	private ZonedDateTime createdDate = ZonedDateTime.now();

	private String lastModifiedBy = "admin";

	private ZonedDateTime lastModifiedDate = ZonedDateTime.now();

    private String status = "active";
		
	private String domain = "test";
		
	Task task=new Task();
	
	@MockBean
	private TaskService taskService;
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	TaskMapper taskMapper=Mappers.getMapper(TaskMapper.class);;
	
	@BeforeEach
    public void initTest() {

		task.setName(name);
		task.setPosition(position);
		task.setCreatedBy(createdBy);
		task.setCreatedDate(createdDate);
		task.setLastModifiedBy(lastModifiedBy);
		task.setLastModifiedDate(lastModifiedDate);
		task.setStatus(status);
		task.setDomain(domain);
		task.setDescription(description);
		task.setIsbillable(isbillable);
		task.setProgress(progress);
    }
	
	@Test
	@DisplayName("should save task to database with rest service")
	public void testSaveUser() throws Exception{
		
		TaskDTO taskDTO=taskMapper.toDto(task);
		
		when(taskService.save(any(TaskDTO.class))).thenReturn(taskDTO);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/api/tasks").with(SecurityMockMvcRequestPostProcessors.csrf())
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(taskMapper.toDto(task))))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(jsonPath("$.name",is(taskDTO.getName())));
	}
	
	@Test
	@DisplayName("should get tasks from database with rest service")
	public void testGetTasks() throws Exception{
		
		TaskDTO taskDTO=taskMapper.toDto(task);
		List<TaskDTO> taskDTOs=new ArrayList<>();
		taskDTOs.add(taskDTO);
		
		Page<TaskDTO> tasksPage=new PageImpl<>(taskDTOs);
		
		when(taskService.getAll(any(Pageable.class))).thenReturn(tasksPage);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/tasks" + "?page=1&size=1")
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(jsonPath("$.size",is(taskDTOs.size())));

	}

}
