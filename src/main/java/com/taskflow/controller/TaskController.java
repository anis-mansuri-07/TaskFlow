package com.taskflow.controller;

import com.taskflow.dto.TaskDto;
import com.taskflow.entity.Task;
import com.taskflow.mapper.TaskMapper;
import com.taskflow.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/task-lists/{id}/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @GetMapping
    public List<TaskDto> getTasks(@PathVariable Long id) {
        return taskService.getTaskByTaskListId(id)
                .stream()
                .map(taskMapper::toDto)
                .toList();
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(
            @PathVariable Long id,
            @RequestBody TaskDto taskDto
    ) {
        Task task = taskMapper.fromDto(taskDto);
        Task savedTask = taskService.createTask(id, task);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(taskMapper.toDto(savedTask));
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<TaskDto> updateTask(
            @PathVariable Long taskId,
            @RequestBody TaskDto taskDto
    ) {
        Task task = taskMapper.fromDto(taskDto);
        task.setId(taskId);
        Task updatedTask = taskService.updateTask(task);
        return ResponseEntity.ok(taskMapper.toDto(updatedTask));
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskDto> getTask(
            @PathVariable Long id,
            @PathVariable Long taskId
    ) {
        return taskService.getTask(id, taskId)
                .map(task -> ResponseEntity.ok(taskMapper.toDto(task)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(
            @PathVariable Long id,
            @PathVariable Long taskId
    ) {

        taskService.getTask(id, taskId)
                .orElseThrow(() -> new IllegalArgumentException("Task not found in this list"));

        taskService.deleteTask(id,taskId);
        return ResponseEntity.noContent().build();
    }


}
