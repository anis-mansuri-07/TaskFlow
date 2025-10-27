package com.taskflow.service;

import com.taskflow.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> getTaskByTaskListId(Long taskListId);
    Task createTask(Long id, Task task);
    Task updateTask(Task task);
    void deleteTask(Long taskId,Long id);
    Optional<Task> getTask(Long taskListId,Long taskId);
}
