package com.task.service.impl;

import java.time.ZonedDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.task.model.Taskgroup;
import com.task.service.TaskGroupService;
import com.task.service.dto.TaskDTO;
import com.task.service.dto.TaskgroupDTO;

@Service
public class TaskGroupServiceImpl implements TaskGroupService{

    private final Logger log = LoggerFactory.getLogger(TaskGroupServiceImpl.class);

    @PersistenceContext
    EntityManager em;


    @Override
    public Taskgroup save() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Taskgroup update() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<TaskgroupDTO> getAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TaskgroupDTO getOne(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<TaskgroupDTO> findByDomainAndOrganization(long organizationId) {
        log.debug("Request to get taskgroups by Domain and taskCollection : {}");

        Stream<Tuple> resultStream = em.createQuery("select distinct " +
                "g.id as group_id, " +
                "g.name as group_name, " +
                "g.icon as group_icon, " +
                "g.position as group_position, " +
                "t.id as task_id, " +
                "t.name as task_name, " +
                "t.status as task_status, " +
                "t.createdBy as task_created_by, " +
                "t.createdDate as task_created_date, " +
                "t.position as task_position " +
                "from Task t " +
                "right outer join t.taskgroup g where " +
                "g.organization.id = " + organizationId,
                Tuple.class)
                .getResultStream();


        Map<Long, TaskgroupDTO> groupDtoMap = new LinkedHashMap<>();
        List<TaskgroupDTO> taskgroupDTOs = resultStream
                .map(tuple -> {
                    TaskgroupDTO taskgroupDto = groupDtoMap.computeIfAbsent(tuple.get("group_id", Long.class),
                            id -> new TaskgroupDTO(tuple.get("group_id", Long.class),
                                    tuple.get("group_name", String.class),
                                    tuple.get("group_icon", byte[].class)));

                   if(tuple.get("task_id", Long.class) != null) {      

                        taskgroupDto.getTaskgroupTasks()
                            .add(new TaskDTO(tuple.get("task_id", Long.class),
                                    tuple.get("task_name", String.class),
                                    tuple.get("task_status", String.class),
                                    tuple.get("task_created_by", String.class),
                                    tuple.get("task_created_date", ZonedDateTime.class), 
                                    tuple.get("task_position", Integer.class)));
                    }
                    return taskgroupDto;
                })
                .distinct()
                .collect(Collectors.toList());

        return taskgroupDTOs;
    }

   
}
