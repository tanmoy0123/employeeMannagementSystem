package com.employeeMannagement.service;

import com.employeeMannagement.exception.ResourceNotFoundException;
import com.employeeMannagement.repository.AddressRepository;
import com.employeeMannagement.repository.DepartmentRepository;
import com.employeeMannagement.repository.EmployeeRepository;
import com.employeeMannagement.repository.TaskRepository;
import com.employeeMannagement.service.department.DepartmentService;
import com.employeeMannagement.dto.AddressDTO;
import com.employeeMannagement.dto.DepartmentDTO;
import com.employeeMannagement.dto.EmployeeDTO;
import com.employeeMannagement.dto.TaskDTO;
import com.employeeMannagement.entity.Address;
import com.employeeMannagement.entity.Department;
import com.employeeMannagement.entity.Employee;
import com.employeeMannagement.entity.Task;
import com.employeeMannagement.mapper.AddressMapper;
import com.employeeMannagement.mapper.DepartmentMapper;
import com.employeeMannagement.mapper.EmployeeMapper;
import com.employeeMannagement.mapper.TaskMapper;
import com.employeeMannagement.service.address.AddressServices;
import com.employeeMannagement.service.employee.EmployeeService;
import com.employeeMannagement.service.task.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceIMPLEMENT implements EmployeeService, AddressServices, DepartmentService, TaskServices {
	
	//Here is started Services  Implements for Employee
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
		Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
		Employee savedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDTO(savedEmployee);
	}
	@Override
	public EmployeeDTO getElementById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException(
				"Employee is not exist with this id " + employeeId
		));
		return EmployeeMapper.mapToEmployeeDTO(employee);
	}
	
	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map((employee) -> {
					return EmployeeMapper.mapToEmployeeDTO(employee);
				}).collect(Collectors.toList());
	}
	
	@Override
	public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updatedEmployee) {
		Employee employee =
				employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException(
				"Employee is not exist with this id " + employeeId
		));
		
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());
		employee.setBirthDate(updatedEmployee.getBirthDate());
		employee.setRole(updatedEmployee.getRole());
		employee.setAddress(updatedEmployee.getAddress());
		employee.setDepartment(updatedEmployee.getDepartment());
//		employee.setTask(updatedEmployee.getTask());
		
		Employee updatedEmployeeObject = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDTO(updatedEmployeeObject);
	}
	
	@Override
	public void deleteEmployee(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException(
				"Employee is not exist with this id " + employeeId
		));
		
		employeeRepository.deleteById(employeeId);
	}
	
	@Override
	public List<EmployeeDTO> getByName(String firstName) {
		List<Employee> employees = employeeRepository.findByFirstName(firstName);
		return employees.stream().map((employee) -> {
			return EmployeeMapper.mapToEmployeeDTO(employee);
		}).collect(Collectors.toList());
	}
	
	//Here is Ending Services Implements for Employee
	
	//Here is Starting Services Implements for Address
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public AddressDTO createAddress(
			AddressDTO addressDTO) {
		Address address = AddressMapper.mapToAddress(addressDTO);
		Address savedAddress = addressRepository.save(address);
		return AddressMapper.mapToAddressDTO(savedAddress);
	}
	
	@Override
	public AddressDTO getAddressById(Long addressId) {
		Address address = addressRepository.findById(addressId).orElseThrow(() -> new RuntimeException(
				"Employee is not exist with this id " + addressId
		));
		return AddressMapper.mapToAddressDTO(address);
	}
	
	@Override
	public List<AddressDTO> getAllAddress() {
		List<Address> addresses = addressRepository
				.findAll();
		
				
		return addresses.stream().map((address) -> {
			return AddressMapper.mapToAddressDTO(address);
		}).collect(Collectors.toList());
	}
	
	@Override
	public AddressDTO updateAddress(
			Long addressId,
			AddressDTO updatedAddress
	) {
		Address address = addressRepository.findById(addressId).orElseThrow(() -> new RuntimeException(
				"Employee is not exist with this id " + addressId
		));
		
		address.setId(updatedAddress.getId());
		address.setStreetName(updatedAddress.getStreetName());
		address.setHouseNumber(updatedAddress.getHouseNumber());
		address.setZipCode(updatedAddress.getZipCode());
		
		Address savedUpdatedAddress = addressRepository.save(address);
		
		return   AddressMapper.mapToAddressDTO(savedUpdatedAddress);
	}
	
	@Override
	public void deleteAddressById(Long addressId) {
		Address address = addressRepository.findById(addressId).orElseThrow(() -> new RuntimeException(
				"Employee is not exist with this id " + addressId
		));
		
		addressRepository.deleteById(addressId);
	}
	
	//Here is Ending Services Implements for Address
	
	
	//Starting Services Implements for Department Entity
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
		Department departmentBody = DepartmentMapper.mapToDepartment(departmentDTO);
		Department departmentEntity = departmentRepository.save(departmentBody);
		return DepartmentMapper.mapToDepartmentDTO(departmentEntity);
	}
	
	@Override
	public DepartmentDTO getAllByIdFromDepartment(Long departmentDTOId) {
		Department departmentEntity = departmentRepository.findById(departmentDTOId)
				.orElseThrow(() -> new RuntimeException(
						"Employee is not exist with this id " + departmentDTOId
				));
		return DepartmentMapper.mapToDepartmentDTO(departmentEntity);
	}
	
	@Override
	public List<DepartmentDTO> getAllFromDepartment() {
		List<Department> allEntities = departmentRepository.findAll();
		return allEntities.stream().map((entity) -> {
			return DepartmentMapper.mapToDepartmentDTO(entity);
		}).collect(Collectors.toList());
	}
	
	@Override
	public DepartmentDTO updateDepartment(Long departmentId, DepartmentDTO departmentDTO) {
		Department department = departmentRepository.findById(departmentId)
				.orElseThrow(() -> new RuntimeException(
						"Department is not exist with this id "+departmentId
				));
		
		department.setName(departmentDTO.getName());
		
		Department savedDepartment = departmentRepository.save(department);
		return DepartmentMapper.mapToDepartmentDTO(savedDepartment);
	}
	
	@Override
	public void deleteByIdFromDepartment(Long departmentDTOId) {
		Department entities = departmentRepository.findById(departmentDTOId)
				.orElseThrow(() -> new RuntimeException(
						"No Id is found on this id "+departmentDTOId
				));
		departmentRepository.deleteById(departmentDTOId);
	}
	
	//Ending Services Implements for Department Entity
	
	//Starting Services Implements for Task Entity
	
	@Autowired
	private TaskRepository taskRepository;
	@Override
	public TaskDTO createTask(TaskDTO taskDTO) {
		Task task = TaskMapper.mapToTask(taskDTO);
		Task savedTask = taskRepository.save(task);
		return TaskMapper.mapToTaskDTO(savedTask);
	}
	
	@Override
	public List<TaskDTO> getAll() {
		List<Task> tasks = taskRepository.findAll();
		return tasks.stream().map((task) -> {
			return TaskMapper.mapToTaskDTO(task);
		}).collect(Collectors.toList());
	}
	
	@Override
	public TaskDTO getById(Long taskId) {
		Task task = taskRepository.findById(taskId)
				.orElseThrow(() -> new RuntimeException(
						"Task is not exist with this id "+taskId
				));
		return TaskMapper.mapToTaskDTO(task);
	}
	
	@Override
	public TaskDTO updateById(Long taskId, TaskDTO taskDTO) {
		Task task = taskRepository.findById(taskId)
				.orElseThrow(() -> new RuntimeException(
						"Task is not exist with this id "+taskId
				));
		
		task.setTaskName(taskDTO.getTaskName());
		task.setDuration(taskDTO.getDuration());
		task.setEmployees(taskDTO.getEmployees());
		
		Task savedUpdatedTask = taskRepository.save(task);
		
		return TaskMapper.mapToTaskDTO(savedUpdatedTask);
	}
	
	@Override
	public void deleteById(Long taskId) {
		Task task = taskRepository.findById(taskId)
				.orElseThrow(() -> new RuntimeException(
						"Task is not exist with this id "+taskId
				));
		taskRepository.deleteById(taskId);
		
	}
	
	//Ending Services Implements for Task Entity
	
}
