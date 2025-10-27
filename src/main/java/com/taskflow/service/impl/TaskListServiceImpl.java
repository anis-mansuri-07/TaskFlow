package com.taskflow.service.impl;

import com.taskflow.entity.TaskList;
import com.taskflow.repo.TaskListRepository;
import com.taskflow.service.TaskListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskListServiceImpl implements TaskListService {

    private final TaskListRepository taskListRepository;


    @Override
    public List<TaskList> getAllTaskLists() {
        return taskListRepository.findAll();
    }

    @Override
    public TaskList createTaskList(TaskList taskList) {
        if(taskList.getId()!=null){
            throw new IllegalArgumentException("Task list already has an Id");
        }
        if(taskList.getTitle()==null || taskList.getTitle().isBlank()){
            throw new IllegalArgumentException("Task list title cannot be null or blank");
        }
        taskListRepository.save(taskList);
        return taskList;

    }

    @Override
    public TaskList updateTaskList(Long id, TaskList updatedTaskList) {
        TaskList existing = taskListRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task list not found with id: " + id));

        if (updatedTaskList.getTitle() != null && !updatedTaskList.getTitle().isBlank()) {
            existing.setTitle(updatedTaskList.getTitle());
        }

        if (updatedTaskList.getDescription() != null) {
            existing.setDescription(updatedTaskList.getDescription());
        }

        return taskListRepository.save(existing);
    }

    @Override
    public void deleteTaskList(Long id) {
        if (!taskListRepository.existsById(id)) {
            throw new IllegalArgumentException("Task list not found with id: " + id);
        }
        taskListRepository.deleteById(id);
    }

    @Override
    public Optional<TaskList> getTaskListById(Long id) {
        return taskListRepository.findById(id);
    }
}
