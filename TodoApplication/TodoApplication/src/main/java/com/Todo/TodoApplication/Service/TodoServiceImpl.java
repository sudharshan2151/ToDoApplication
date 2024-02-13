package com.Todo.TodoApplication.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Todo.TodoApplication.DTO.TaskDTO;
import com.Todo.TodoApplication.Model.Task;
import com.Todo.TodoApplication.Repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {
	private TodoRepository todoRepository;

	
	public TodoServiceImpl(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	
	
	/**
	 * postMapping
	 */
	@Override
	public TaskDTO addTask(TaskDTO task) {
		// TODO Auto-generated method stub
		Task t = mapToModel(task);
		Task save = todoRepository.save(t);
		return mapToDTO(save);
		
	}
	/**
	 * 
	 * @param TaskDTO
	 * @return
	 */
	public Task mapToModel(TaskDTO task) {
		return new Task(task.getName(),task.getDescription(),task.isCompleted());
	}
	
	/**
	 * 
	 * @param Task
	 * @return
	 */
	public TaskDTO mapToDTO(Task task){
		return new TaskDTO(task.getId(),task.getName(),task.getDescription(),task.getTime(),task.isCompleted());
	}
	/**
	 * 
	 */
	@Override
	public List<TaskDTO> getAll() {
		// TODO Auto-generated method stub
		List<Task> findAll = todoRepository.findAll();
		List<TaskDTO> res = new ArrayList<>();
		for(Task a : findAll)res.add(mapToDTO(a));
		return res;
		
	}
	@Override
	public TaskDTO getById(int id) {
		// TODO Auto-generated method stub
		Optional<Task> findById = todoRepository.findById(id);
		return mapToDTO(findById.get());
	}
	
	
	@Override
	public TaskDTO updateById(TaskDTO task) {
		// TODO Auto-generated method stub
		Task findById = todoRepository.findById(task.getId()).get();
		findById.setName(task.getName());
		findById.setDescription(task.getDescription());
		findById.setTime(LocalDateTime.now());
		findById.setCompleted(task.isCompleted());
		Task save = todoRepository.save(findById);
		return mapToDTO(save);
	}
	
	@Override
	public void deleteTask(int id) {
		// TODO Auto-generated method stub
		
		Task task = todoRepository.findById(id).get();
		todoRepository.delete(task);
	}


	@Override
	public List<TaskDTO> pagination(int page, int size) {
		// TODO Auto-generated method stub
		
		 Pageable a = PageRequest.of(page, size);
		 Page<Task> findAll = todoRepository.findAll(a);
		 List<Task> content = findAll.getContent();
		 List<TaskDTO> res = new ArrayList<>();
		 for(Task a1 : content) {
			 res.add(mapToDTO(a1));
		 }
		 return res;
		 
	}


	@Override
	public TaskDTO markComplete(int id) {
		// TODO Auto-generated method stub
		Task ta = todoRepository.findById(id).get();
		ta.setCompleted(true);
		Task save = todoRepository.save(ta);
		return mapToDTO(save);
	}
	@Override
	public TaskDTO markInComplete(int id) {
		// TODO Auto-generated method stub
		Task ta = todoRepository.findById(id).get();
		ta.setCompleted(false);
		Task save = todoRepository.save(ta);
		return mapToDTO(save);
	}

}
