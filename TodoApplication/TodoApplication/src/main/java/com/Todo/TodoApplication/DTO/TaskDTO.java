package com.Todo.TodoApplication.DTO;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
	
	private int id;
	private String name;
	private String description;
	@CreationTimestamp
	private LocalDateTime time;
	private boolean completed;
	
	public TaskDTO(String name, String description, LocalDateTime time, boolean completed) {
		super();
		this.name = name;
		this.description = description;
		this.time = time;
		this.completed = completed;
	}
	
}
