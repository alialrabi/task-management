package com.task.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.task.model.Task;
import com.task.service.dto.TaskDTO;

public interface TaskService {

    public TaskDTO save(TaskDTO taskDTO);

    public Task update(Task task);

    public Page<TaskDTO> getAll(Pageable pageable);

    public TaskDTO getOne(long id);

    public void delete(long id);
    
}
