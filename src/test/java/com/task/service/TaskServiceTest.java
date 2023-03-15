package com.task.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.ZonedDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.task.model.Task;
import com.task.repository.TaskRepository;
import com.task.service.dto.TaskDTO;
import com.task.service.impl.TaskServiceImpl;
import com.task.service.mapper.TaskMapper;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {
	
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
	
	@InjectMocks
	TaskServiceImpl  taskService;
	
	@Mock
	TaskRepository taskRepository;
	
	@Spy
	@InjectMocks
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
	@DisplayName("should save task to database")
	public void testSaveUser() throws Exception{
				
		when(taskRepository.save(any(Task.class))).thenReturn(task);
		TaskDTO newTask= taskService.save(taskMapper.toDto(task));	
		
		assertNotNull(newTask);
		assertEquals(newTask.getName(), name);

	}

}
