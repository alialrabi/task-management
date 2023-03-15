package com.task.service;

import org.springframework.data.domain.Page;

import com.task.model.Tag;

public interface TagService {

    public Tag save();

    public Tag update();

    public Page<Tag> getAll();

    public Tag getOne();

    public void delete();
    
}
