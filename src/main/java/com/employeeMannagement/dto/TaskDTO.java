package com.employeeMannagement.dto;

import com.employeeMannagement.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
	private Long id;
	private String taskName;
	private int duration;
	private List<Employee> employees;
	private Employee employee;
	
	public TaskDTO(Long id, String taskName, int duration,Employee employee) {
	}
}
