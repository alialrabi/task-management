package com.task.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.task.model.Taskstatus;
import com.task.repository.TaskstatusRepository;
import com.task.service.TaskStatusService;

@Service
public class TaskStatusServiceImpl implements TaskStatusService {

    private final TaskstatusRepository taskstatusRepository;

    public TaskStatusServiceImpl(TaskstatusRepository taskstatusRepository) {
        this.taskstatusRepository = taskstatusRepository;
    }    

    @Override
    public Taskstatus save(Taskstatus taskstatus) {
        return taskstatusRepository.save(taskstatus);
    }

    @Override
    public Taskstatus update() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<Taskstatus> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Taskstatus getOne() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete() {
        // TODO Auto-generated method stub
        
    }
    
}
