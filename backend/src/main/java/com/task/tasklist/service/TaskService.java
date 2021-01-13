package com.task.tasklist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.tasklist.repositories.TaskRepositorie;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepositorie taskRepositorie;
	

}
