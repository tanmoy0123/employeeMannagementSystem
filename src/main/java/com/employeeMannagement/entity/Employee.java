package com.employeeMannagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "birth_date")
	private LocalDate birthDate;
	
	@Column(name = "role")
	private String role;
	
	@OneToOne
	@JoinColumn(name = "fk_address_id", referencedColumnName = "address_id")
	private Address address;
	
	@OneToOne
	@JoinColumn(name = "fk_dept_id", referencedColumnName = "dept_id")
	private Department department;
	
//	@ManyToOne
//	@JoinColumn(name = "task_id")
//	private Task task;
	
	
	
	
}
