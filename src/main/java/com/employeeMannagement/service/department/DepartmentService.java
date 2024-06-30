package com.employeeMannagement.service.department;

import com.employeeMannagement.dto.DepartmentDTO;

import java.util.List;


public interface DepartmentService {
	DepartmentDTO createDepartment(DepartmentDTO departmentDTO);
	DepartmentDTO getAllByIdFromDepartment(Long departmentDTOId);
	List<DepartmentDTO> getAllFromDepartment();
	DepartmentDTO updateDepartment(Long departmentId, DepartmentDTO departmentDTO);
	void deleteByIdFromDepartment(Long departmentDTOId);
}
