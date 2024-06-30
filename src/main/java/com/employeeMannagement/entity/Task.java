package com.employeeMannagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "task")
public class Task {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "task_name")
	private String taskName;
	private int duration;
	
	@OneToMany()
	private List<Employee> employees;
	
	@ManyToOne
	private Employee employee;
}
