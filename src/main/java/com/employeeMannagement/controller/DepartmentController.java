package com.employeeMannagement.controller;

import com.employeeMannagement.service.department.DepartmentService;
import com.employeeMannagement.dto.DepartmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping
	public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO departmentBody){
		 DepartmentDTO savedEntity = departmentService.createDepartment(departmentBody);
		 return new ResponseEntity<>(savedEntity, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<DepartmentDTO> getAllByIdFromDepartment(
			@PathVariable("id") Long departmentIdByBody){
		DepartmentDTO getAllEntity = departmentService.getAllByIdFromDepartment(departmentIdByBody);
		return ResponseEntity.ok(getAllEntity);
	}
	
	@GetMapping
	public ResponseEntity<List<DepartmentDTO>> getAllFromDepartment(){
		List<DepartmentDTO> allEntites = departmentService.getAllFromDepartment();
		return ResponseEntity.ok(allEntites);
	};
	
	@PutMapping("{id}")
	public ResponseEntity<DepartmentDTO> updateDepartment(
			@PathVariable("id") Long departmentId,
			@RequestBody DepartmentDTO departmentDTO
	) {
		DepartmentDTO updatedEntity = departmentService.updateDepartment(departmentId, departmentDTO);
		return ResponseEntity.ok(updatedEntity);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteByIdFromDepartment(
			@PathVariable("id") Long departmentIdBody
	) {
		departmentService.deleteByIdFromDepartment(departmentIdBody);
		return ResponseEntity.ok(departmentIdBody +" Department deleted successfully");
	}
}
