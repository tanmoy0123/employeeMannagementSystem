package com.employeeMannagement.dto;

import com.employeeMannagement.entity.Address;
import com.employeeMannagement.entity.Department;
import com.employeeMannagement.entity.Task;
import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private LocalDate birthDate;
	private String role;
	private Address address;
	private Department department;
	private Task task;
	
	public EmployeeDTO(long id, String firstName, String lastName, String email, LocalDate birthDate, String role, Address address, Department department) {
	}
}
