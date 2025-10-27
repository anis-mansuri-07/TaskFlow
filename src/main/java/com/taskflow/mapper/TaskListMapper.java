package com.taskflow.mapper;

import com.taskflow.dto.TaskListDto;
import com.taskflow.entity.TaskList;

public interface TaskListMapper {
    TaskList fromDto(TaskListDto taskListDto);
    TaskListDto toDto(TaskList taskList);
}
