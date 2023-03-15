package com.task.service;

import org.springframework.data.domain.Page;

import com.task.model.Taskstatus;

public interface TaskStatusService {

    public Taskstatus save(Taskstatus taskstatus);

    public Taskstatus update();

    public Page<Taskstatus> getAll();

    public Taskstatus getOne();

    public void delete();
    
}
