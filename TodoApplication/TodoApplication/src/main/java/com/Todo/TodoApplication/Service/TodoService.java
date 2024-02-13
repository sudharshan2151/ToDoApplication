package com.Todo.TodoApplication.Service;

import java.util.List;

import com.Todo.TodoApplication.DTO.TaskDTO;

public interface TodoService {
	
	TaskDTO addTask(TaskDTO task);

	List<TaskDTO> getAll();

	TaskDTO getById(int id);

	TaskDTO updateById(TaskDTO task);

	void deleteTask(int id);

	List<TaskDTO> pagination(int page, int size);

	TaskDTO markComplete(int id);

	TaskDTO markInComplete(int id);
}
