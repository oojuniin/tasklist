package com.task.tasklist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.tasklist.entities.Task;

public interface TaskRepositorie extends JpaRepository<Task, Long> {

	public Task findByTitle(String title);
}
