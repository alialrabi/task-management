package com.task.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.task.model.Task;
import com.task.service.dto.TaskDTO;

public interface TaskRepository extends JpaRepository<Task, Long>{
    
	@Query("select new com.task.service.dto.TaskDTO(t.id, t.name, t.status,t.createdBy,\n"
			+ " t.createdDate , t.position) from Task t")
	public Page<TaskDTO> getTasks(Pageable pageable);
}
