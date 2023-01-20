package com.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.model.Taskstatus;

public interface TaskstatusRepository extends JpaRepository<Taskstatus, Long>{
    
}
