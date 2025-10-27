package com.taskflow.mapper.impl;

import com.taskflow.dto.TaskListDto;
import com.taskflow.entity.Task;
import com.taskflow.entity.TaskList;
import com.taskflow.entity.TaskStatus;
import com.taskflow.mapper.TaskListMapper;
import com.taskflow.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TaskListMapperImpl implements TaskListMapper {
    private final TaskMapper taskMapper;
    @Override
    public TaskList fromDto(TaskListDto taskListDto) {
        return new TaskList(
                taskListDto.id(),
                taskListDto.title(),
                taskListDto.description(),
                Optional.ofNullable(taskListDto.tasks())
                        .map(tasks -> tasks.stream().map(taskMapper::fromDto).toList()
                        ).orElse(null),
                null,
                null

        );
    }

    @Override
    public TaskListDto toDto(TaskList taskList) {
        return new TaskListDto(
                taskList.getId(),
                taskList.getTitle(),
                taskList.getDescription(),
                Optional.ofNullable(taskList.getTasks())
                        .map(List::size).orElse(0),
                calculateTaskListProgress(taskList.getTasks()),
                Optional.ofNullable(taskList.getTasks())
                        .map(tasks -> tasks.stream()
                                .map(taskMapper::toDto).toList()
                        ).orElse(null)
        );
    }

    private Double calculateTaskListProgress(List<Task> task) {
        if (task == null || task.isEmpty()) {
            return 0.0;
        }
        long completedTasks = task.stream()
                .filter(t -> t.getStatus() == TaskStatus.CLOSED)
                .count();
        return (completedTasks / (double) task.size()) * 100;
    }
}
