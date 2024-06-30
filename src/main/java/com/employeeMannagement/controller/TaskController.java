package com.employeeMannagement.controller;

import com.employeeMannagement.dto.TaskDTO;
import com.employeeMannagement.service.task.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {
	@Autowired
	private TaskServices taskServices;
	
	@PostMapping
	public ResponseEntity<TaskDTO> createTask(
			@RequestBody TaskDTO taskDTO
	){
		TaskDTO savedDto = taskServices.createTask(taskDTO);
		return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<TaskDTO>> getAll(){
		List<TaskDTO> entities = taskServices.getAll();
		return ResponseEntity.ok(entities);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<TaskDTO> getById(
			@PathVariable("id") Long taskID
	) {
		TaskDTO gotEntities = taskServices.getById(taskID);
		return ResponseEntity.ok(gotEntities);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<TaskDTO> updateTask(
			@PathVariable("id") Long taskId,
			@RequestBody TaskDTO taskDTO
	) {
		TaskDTO savedTask = taskServices.updateById(taskId, taskDTO);
		return ResponseEntity.ok(savedTask);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Long givenTaskId){
		taskServices.deleteById(givenTaskId);
		return ResponseEntity.ok("The given task is deleted successfully with the give id "+givenTaskId);
	}
}
