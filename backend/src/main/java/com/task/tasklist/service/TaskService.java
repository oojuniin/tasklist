package com.task.tasklist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.tasklist.entities.Task;
import com.task.tasklist.exception.TaskNotFoundException;
import com.task.tasklist.repositories.TaskRepositorie;

@Service
public class TaskService {

	@Autowired
	private TaskRepositorie taskRepositorie;

	public List<Task> findAll() {
		List<Task> list = taskRepositorie.findAll();
		return list;
	}

	public Optional<Task> findById(Long id) {
		return taskRepositorie.findById(id);
	}

	public Task findByTitle(Task task) {
		task = taskRepositorie.findByTitle(task.getTitle());
		if (task == null) {
			return new Task();
		}
		return task;
	}

	public Task save(Task task) {
		return taskRepositorie.save(task);
	}
	
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
