package com.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.model.Taskgroup;

public interface TaskgroupRepository extends JpaRepository<Taskgroup, Long>{
    
}
