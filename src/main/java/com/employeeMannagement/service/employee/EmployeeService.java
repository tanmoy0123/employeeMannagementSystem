package com.employeeMannagement.service.employee;

import com.employeeMannagement.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
	EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
	EmployeeDTO getElementById(Long employeId);
	List<EmployeeDTO> getAllEmployees();
	
	EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updatedEmployee);
	void deleteEmployee(Long employeeId);
	
	List<EmployeeDTO> getByName(String firstName);
}
