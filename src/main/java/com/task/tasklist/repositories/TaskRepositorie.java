package com.task.tasklist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.task.tasklist.entities.Task;

public interface TaskRepositorie extends JpaRepository<Task, Long>, CrudRepository<Task, Long> {

	public Task findByTitle(String title);
}
