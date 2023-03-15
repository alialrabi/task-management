package com.task.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.task.model.Taskgroup;
import com.task.service.dto.TaskgroupDTO;

public interface TaskGroupService {

    public Taskgroup save();

    public Taskgroup update();

    public Page<TaskgroupDTO> getAll(Pageable pageable);

    public TaskgroupDTO getOne(long id);

    public void delete();

    public List<TaskgroupDTO> findByDomainAndOrganization(long organizationId);
    
}
