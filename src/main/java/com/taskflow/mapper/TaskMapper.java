package com.taskflow.mapper;

import com.taskflow.dto.TaskDto;
import com.taskflow.entity.Task;

public interface TaskMapper {

    Task fromDto(TaskDto taskDto);

    TaskDto toDto(Task task);
}
