package com.task.tasklist.dto;

import java.io.Serializable;

import com.task.tasklist.entities.Task;
import com.task.tasklist.enums.TaskStatus;

public class TaskDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String tittle;
	private String description;
	private TaskStatus status;

	public TaskDTO() {
	}

	public TaskDTO(Long id, String tittle, String description, TaskStatus status) {
		this.id = id;
		this.tittle = tittle;
		this.description = description;
		this.status = status;
	}

	public TaskDTO(Task task) {
		this.id = task.getId();
		this.tittle = task.getTittle();
		this.description = task.getDescription();
		this.status = task.getStatus();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskDTO other = (TaskDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
