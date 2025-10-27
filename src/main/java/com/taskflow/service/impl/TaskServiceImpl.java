package com.taskflow.service.impl;

import com.taskflow.entity.Task;
import com.taskflow.entity.TaskList;
import com.taskflow.entity.TaskPriority;
import com.taskflow.entity.TaskStatus;
import com.taskflow.repo.TaskListRepository;
import com.taskflow.repo.TaskRepository;
import com.taskflow.service.TaskService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskListRepository taskListRepository;


    @Override
    public List<Task> getTaskByTaskListId(Long taskListId) {

        return taskRepository.findByTaskListId(taskListId);
    }

    @Override
    public Task createTask(Long taskListId, Task task) {
        if (task.getId() != null) {
            throw new IllegalArgumentException("Task already has an ID. Can't create.");
        }
        if (task.getTitle() == null || task.getTitle().isBlank()) {
            throw new IllegalArgumentException("Task title is required");
        }

        task.setPriority(Optional.ofNullable(task.getPriority()).orElse(TaskPriority.MEDIUM));

        task.setStatus(TaskStatus.OPEN);

        TaskList taskList = taskListRepository.findById(taskListId)
                .orElseThrow(() -> new IllegalArgumentException("TaskList with id " + taskListId + " not found"));

        task.setTaskList(taskList);

        return taskRepository.save(task);
    }

    @Transactional
    @Override
    public Task updateTask(Task task) {
        if (task.getId() == null) {
            throw new IllegalArgumentException("Task ID is required for update");
        }

        Task existingTask = taskRepository.findById(task.getId())
                .orElseThrow(() -> new IllegalArgumentException("Task with id " + task.getId() + " not found"));

        if (task.getTitle() != null && !task.getTitle().isBlank()) {
            existingTask.setTitle(task.getTitle());
        }

        if (task.getDescription() != null) {
            existingTask.setDescription(task.getDescription());
        }
        if (task.getDueTime() != null) {
            existingTask.setDueTime(task.getDueTime());
        }

        existingTask.setPriority(Optional.ofNullable(task.getPriority()).orElse(existingTask.getPriority()));
        existingTask.setStatus(Optional.ofNullable(task.getStatus()).orElse(existingTask.getStatus()));

        return taskRepository.save(existingTask);
    }


    @Transactional
    @Override
    public void deleteTask(Long taskId,Long id) {
        taskRepository.deleteByTaskListIdAndId(taskId, id);

    }

    @Override
    public Optional<Task> getTask(Long taskListId, Long taskId) {
        return taskRepository.findByTaskListIdAndId(taskListId, taskId);
    }

}
