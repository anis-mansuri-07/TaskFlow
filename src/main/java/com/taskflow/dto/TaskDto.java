package com.taskflow.dto;

import com.taskflow.entity.TaskPriority;
import com.taskflow.entity.TaskStatus;

import java.time.LocalDateTime;

public record TaskDto(
        Long id,
        String title,
        String description,
        LocalDateTime dueTime,
        TaskPriority priority,
        TaskStatus status
) {
}
