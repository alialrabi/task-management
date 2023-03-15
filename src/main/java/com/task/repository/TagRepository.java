package com.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Long>{
    
}
