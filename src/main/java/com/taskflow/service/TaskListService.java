package com.taskflow.service;

import com.taskflow.entity.TaskList;

import java.util.List;
import java.util.Optional;

public interface TaskListService {
    List<TaskList> getAllTaskLists();
    TaskList createTaskList(TaskList taskList);
    TaskList updateTaskList(Long id, TaskList updatedTaskList);
    void deleteTaskList(Long id);
    Optional<TaskList> getTaskListById(Long id);
}
