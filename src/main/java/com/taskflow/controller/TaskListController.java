package com.taskflow.controller;


import com.taskflow.dto.TaskListDto;
import com.taskflow.entity.TaskList;
import com.taskflow.mapper.TaskListMapper;
import com.taskflow.service.TaskListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping( "/api/task-lists")
@RequiredArgsConstructor
public class TaskListController {

    private final TaskListService taskListService;
    private final TaskListMapper taskListMapper;
    @GetMapping
    public List<TaskListDto> getAllTaskLists() {
       return taskListService.getAllTaskLists()
                .stream()
                .map(taskListMapper::toDto)
                .toList();
    }

    @PostMapping
    public ResponseEntity<TaskListDto> createTaskList(@RequestBody TaskListDto taskListDto) {
        TaskList taskList = taskListMapper.fromDto(taskListDto);
        TaskList saved = taskListService.createTaskList(taskList);
        TaskListDto savedObj = taskListMapper.toDto(saved);
        return new ResponseEntity<>(savedObj, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<TaskListDto> updateTaskList(
            @PathVariable Long id,
            @RequestBody TaskListDto taskListDto
    ) {
        TaskList updatedData = taskListMapper.fromDto(taskListDto);
        TaskList updated = taskListService.updateTaskList(id, updatedData);
        return ResponseEntity.ok(taskListMapper.toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskList(@PathVariable Long id) {
        taskListService.deleteTaskList(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskListDto> getTaskListById(@PathVariable Long id) {
        return taskListService.getTaskListById(id)
                .map(taskList -> ResponseEntity.ok(taskListMapper.toDto(taskList)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
