package com.Todo.TodoApplication.Controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Todo.TodoApplication.DTO.TaskDTO;
import com.Todo.TodoApplication.Service.TodoService;


@CrossOrigin
@RestController
public class Todocontroller {
	
	@Autowired
	private TodoService taskService;
	private final Logger logger = LogManager.getLogger(Todocontroller.class.getName());

	/**
	 * 
	 * @param task
	 * @return
	 */
    @PostMapping("/todo")
    public ResponseEntity<TaskDTO> addTask(@RequestBody TaskDTO task){
    	logger.info("Enter to the add Task and calling the service method");
		TaskDTO addTask = taskService.addTask(task);
    	return new ResponseEntity(addTask,HttpStatus.CREATED);
    }
    
    /**
     * Getall method()
     * @return
     */
    @GetMapping("/todo")
    public ResponseEntity<List<TaskDTO>> viewAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue="10") int size){
    	logger.info("Enter to the viewAll Task in the pagination");
    
    	List<TaskDTO> pagination = taskService.pagination(page,size);
    	return new ResponseEntity(pagination,HttpStatus.FOUND);
    }
    
    @GetMapping("/todo/entries")
    public ResponseEntity<List<TaskDTO>> viewAllEntries(){
    	logger.info("Enter to the viewAll Task ");
	    List<TaskDTO> all = taskService.getAll();
	    return new ResponseEntity(all,HttpStatus.FOUND);	
	   
    }
    
    
    /**
     * 
     * @param id
     * @return
     */
    @GetMapping("/todo/{id}")
    public ResponseEntity<TaskDTO> viewById(@PathVariable int id){
    	TaskDTO byId = taskService.getById(id);
    	return ResponseEntity.ok(byId);
    }
    
    
    /**
     * 
     * @param task
     * @return
     */
    @PutMapping("/todo/{id}")
    public ResponseEntity<TaskDTO> updateById(@PathVariable int id,@RequestBody TaskDTO task){
    	TaskDTO updateById = taskService.updateById(task);
    	return new ResponseEntity(updateById,HttpStatus.CREATED);
    }
    
    /**
     * 
     * @param id
     * @return
     */
    @DeleteMapping("/todo/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable int id){
    	taskService.deleteTask(id);
    	return ResponseEntity.ok("Deleted sucessfully");
    }
    
    @PutMapping("/todo/{id}/complete")
    public ResponseEntity<TaskDTO> markComplete(@PathVariable int id){
    	TaskDTO markComplete = taskService.markComplete(id);
    	return ResponseEntity.ok(markComplete);
    }
    
    @PutMapping("/todo/{id}/Incomplete")
    public ResponseEntity<TaskDTO> markInComplete(@PathVariable int id){
    	TaskDTO markComplete = taskService.markInComplete(id);
    	return ResponseEntity.ok(markComplete);
    }
    
    
}
