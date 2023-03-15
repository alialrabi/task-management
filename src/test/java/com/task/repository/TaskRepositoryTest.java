package com.task.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.ZonedDateTime;
import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.task.model.Task;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
public class TaskRepositoryTest {

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
	
	@Autowired
	TaskRepository taskRepository;
	
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
	@Transactional
	@DisplayName("should save task to database")
	public void testSaveUser() throws Exception{
		
		Task newTask= taskRepository.save(task);		
		
		assertNotNull(newTask);
		assertNotNull(newTask.getId());
		assertEquals(newTask.getName(), name);
		//mockMvc.perform(MockMvcRequestBuilders.post("/api/users"))
			//	.andExpect(MockMvcResultMatchers.status().isOk());
	}

}

