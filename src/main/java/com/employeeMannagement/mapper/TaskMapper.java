package com.employeeMannagement.mapper;

import com.employeeMannagement.entity.Task;
import com.employeeMannagement.dto.TaskDTO;

public class TaskMapper {
	
	public static TaskDTO mapToTaskDTO(Task task){
		return new TaskDTO(
				task.getId(),
				task.getTaskName(),
				task.getDuration(),
				task.getEmployees(),
				task.getEmployee()
		);
	}
	
	public static Task mapToTask(TaskDTO taskDTO){
		return new Task(
				taskDTO.getId(),
				taskDTO.getTaskName(),
				taskDTO.getDuration(),
				taskDTO.getEmployees(),
				taskDTO.getEmployee()
		);
	}
}
