package com.task.tasklist.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.task.tasklist.entities.Task;
import com.task.tasklist.services.TaskService;

@RestController
@RequestMapping(value = "/api/task")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@GetMapping(value = "/")
	public ResponseEntity<List<Task>> findAll() {
		List<Task> list = taskService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{title}")
	public ResponseEntity<Task> findByTitle(Task task) {
		task = taskService.findByTitle(task);
		return ResponseEntity.ok().body(task);
	}

	@PostMapping
	public ResponseEntity<Task> create(@RequestBody Task task) {
		task = taskService.save(task);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(task.getId()).toUri();
		return ResponseEntity.created(uri).body(task);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Task> update(@RequestBody Task intask, @PathVariable Long id) {		
		Task task = taskService.update(id, intask);
		return ResponseEntity.ok().body(task);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Optional<Task>> delete(@PathVariable Long id) {
		Optional<Task> task = taskService.delete(id);
		return ResponseEntity.ok().body(task);
	}

}
