package com.employeeMannagement.mapper;

import com.employeeMannagement.entity.Employee;
import com.employeeMannagement.dto.EmployeeDTO;

public class EmployeeMapper {
	
	
	public static EmployeeDTO mapToEmployeeDTO(Employee employee){
//		EmployeeDTO employeeDTO = new EmployeeDTO();
//		employeeDTO.setId(employee.getId());
//		employeeDTO.setFirstName(employee.getFirstName());
//		employeeDTO.setLastName(employee.getLastName());
//		employeeDTO.setEmail(employee.getEmail());
//		employeeDTO.setBirthDate(employee.getBirthDate());
//		employeeDTO.setRole(employee.getRole());
//		employeeDTO.setAddress(employeeDTO.getAddress());
//		employeeDTO.setDepartment(employee.getDepartment());
//		employeeDTO.setTasks(employee.getTasks());
//
//		return employeeDTO;
		
		
		return new EmployeeDTO(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail(),
				employee.getBirthDate(),
				employee.getRole(),
				employee.getAddress(),
				employee.getDepartment()
//				employee.getTask()
		);
	}
	
	public static Employee mapToEmployee(EmployeeDTO employeeDTO){
//		Employee employee = new Employee();
//		employee.setId(employeeDTO.getId());
//		employee.setFirstName(employeeDTO.getFirstName());
//		employee.setLastName(employeeDTO.getLastName());
//		employee.setEmail(employeeDTO.getEmail());
//		employee.setBirthDate(employeeDTO.getBirthDate());
//		employee.setRole(employeeDTO.getRole());
//		employee.setAddress(employeeDTO.getAddress());
//		employee.setDepartment(employeeDTO.getDepartment());
//		employee.setTasks(employeeDTO.getTasks());
//
//		return employee;
		
		return new Employee(
				employeeDTO.getId(),
				employeeDTO.getFirstName(),
				employeeDTO.getLastName(),
				employeeDTO.getEmail() ,
				employeeDTO.getBirthDate(),
				employeeDTO.getRole(),
				employeeDTO.getAddress(),
				employeeDTO.getDepartment()
//				employeeDTO.getTask()
		);
	}
}
