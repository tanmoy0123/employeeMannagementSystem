package com.employeeMannagement.controller;

import com.employeeMannagement.dto.EmployeeDTO;
import com.employeeMannagement.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
		
	//Build ADD Employee REST API
	@PostMapping
	public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
		EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}
	
	//Build Get Employee By ID REST API
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long employeeId){
		EmployeeDTO employeeDTO = employeeService.getElementById(employeeId);
		return ResponseEntity.ok(employeeDTO);
	}
	
	//Build Get All Employee REST API
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> getAllEmployess(){
		List<EmployeeDTO> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
	}
	
	//Find By First Name
	@GetMapping("/find/{firstName}")
	public ResponseEntity<List<EmployeeDTO>> getByName(@PathVariable("firstName") String firstName){
		List<EmployeeDTO> byNameEmployess = employeeService.getByName(firstName);
		return ResponseEntity.ok(byNameEmployess);
	}
	
	//Build Updated Employee REST API
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDTO>  updatedEmployee(
			@PathVariable("id") Long employeeId,
			@RequestBody EmployeeDTO updatedEmployee
	) {
		EmployeeDTO employeeDTO = employeeService.updateEmployee(employeeId, updatedEmployee);
		return ResponseEntity.ok(employeeDTO);  
	}
	
	//Build Delete By Id From Employee REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
		employeeService.deleteEmployee(employeeId);
		return ResponseEntity.ok("Employee Deleted Successfully!.");
	}
	
}
