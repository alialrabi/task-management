package com.task.service.impl;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.task.exception.TaskNotFoundException;
import com.task.model.Task;
import com.task.repository.TaskRepository;
import com.task.service.TaskService;
import com.task.service.dto.TaskDTO;
import com.task.service.mapper.TaskMapper;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }    

    @Override
    public TaskDTO save(TaskDTO taskDTO) {
    	 return taskMapper.toDto(taskRepository.save(taskMapper.toEntity(taskDTO)));
    }

    @Override
    public Task update(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Page<TaskDTO> getAll(Pageable pageable) {
        return taskRepository.getTasks(pageable);
    }
    
    @Override
    @Cacheable(value = "taskDto" ,key = "#id")
    public TaskDTO getOne(long id) {
        TaskDTO taskdDto= taskRepository.findById(id).map(taskMapper::toDto).orElseThrow(() -> new TaskNotFoundException("Task not found"));
        return taskdDto;
    }

    @Override
    public void delete(long id) {
        taskRepository.deleteById(id);        
    }
    
}
