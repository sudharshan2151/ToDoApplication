package com.Todo.TodoApplication.Model;

import java.time.LocalDateTime;


import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Task")
@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	@CreationTimestamp
	private LocalDateTime time;
	private boolean completed;
	public Task(String name, String description,  boolean completed) {
		super();
		this.name = name;
		this.description = description;
		this.completed = completed;
	}
}
