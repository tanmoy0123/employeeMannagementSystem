package com.employeeMannagement.mapper;

import com.employeeMannagement.entity.Department;
import com.employeeMannagement.dto.DepartmentDTO;

public class DepartmentMapper {
	
	public static DepartmentDTO mapToDepartmentDTO(Department department){
		return new DepartmentDTO(
				department.getId(),
				department.getName()
		);
	}
	
	public static Department mapToDepartment(DepartmentDTO departmentDTO){
		return new Department(
				departmentDTO.getId(),
				departmentDTO.getName()
		);
	}
}
