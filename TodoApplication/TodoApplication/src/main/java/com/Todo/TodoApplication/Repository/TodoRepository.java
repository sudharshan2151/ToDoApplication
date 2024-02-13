package com.Todo.TodoApplication.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Todo.TodoApplication.Model.Task;


@Repository
public interface TodoRepository extends JpaRepository<Task, Integer>{
	Page<Task> findAll(Pageable page);
}
