package com.employeeMannagement.service.task;

import com.employeeMannagement.dto.TaskDTO;

import java.util.List;

public interface TaskServices {
	
	TaskDTO createTask(TaskDTO taskDTO);
	
	List<TaskDTO> getAll();
	
	TaskDTO getById(Long taskId);
	
	TaskDTO updateById(Long taskId, TaskDTO taskDTO);
	
	void deleteById(Long taskId);
}
