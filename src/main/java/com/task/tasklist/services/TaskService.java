package com.task.tasklist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.task.tasklist.entities.Task;
import com.task.tasklist.exceptions.TaskNotFoundException;
import com.task.tasklist.repositories.TaskRepositorie;

@Service
public class TaskService {

	@Autowired
	private TaskRepositorie taskRepositorie;

	@Transactional(readOnly = true)
	public List<Task> findAll() {
		List<Task> list = taskRepositorie.findAll();
		return list;
	}

	@Transactional(readOnly = true)
	public Optional<Task> findById(Long id) {
		return taskRepositorie.findById(id);
	}

	@Transactional(readOnly = true)
	public Task findByTitle(Task task) {
		task = taskRepositorie.findByTitle(task.getTitle());
		if (task == null) {
			return new Task();
		}
		return task;
	}

	@Transactional
	public Task save(Task task) {
		return taskRepositorie.save(task);
	}
	
	@Transactional
	public Task update(Long id, Task intask){
		
		Task task = taskRepositorie.findById(id).orElseThrow(() -> new TaskNotFoundException("No product with id: " + id));
		
		Task newTask = new Task();
		
		newTask.setId(task.getId());
		newTask.setTitle(intask.getTitle());
		newTask.setDescription(intask.getDescription());
		newTask.setStatus(intask.getStatus());
		
		taskRepositorie.save(newTask);
		
		return newTask;
	}
	
	@Transactional
	public Optional<Task> delete(Long id) {
		Optional<Task> task = taskRepositorie.findById(id);
		
		if(task.isEmpty()) {
			Optional<Task> empty = Optional.empty();
			return empty;
		}
		
		taskRepositorie.deleteById(id);
		return task;
	}
}
