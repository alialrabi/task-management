package com.task.service.mapper;
import org.mapstruct.*;
import com.task.service.dto.TaskDTO;
import com.task.model.Task;;

@Mapper(componentModel = "spring")
public interface TaskMapper extends EntityMapper<TaskDTO, Task>{
    
    TaskDTO toDto(Task task);
}
