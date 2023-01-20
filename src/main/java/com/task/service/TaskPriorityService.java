package com.task.service;

import org.springframework.data.domain.Page;

import com.task.model.Taskpriority;

public interface TaskPriorityService {

    public Taskpriority save();

    public Taskpriority update();

    public Page<TaskPriorityService> getAll();

    public Taskpriority getOne();

    public void delete();
}
