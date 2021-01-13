package com.task.tasklist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.tasklist.dto.TaskDTO;
import com.task.tasklist.service.TaskService;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@GetMapping(value = "listAllTasks")
	public ResponseEntity<List<TaskDTO>> listAllTasks(){
		
	}
}
