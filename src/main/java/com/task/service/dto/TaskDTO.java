package com.task.service.dto;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;

import com.task.model.Metadata;
import com.task.model.Taskgroup;

public class TaskDTO implements Serializable {
    
    private Long id;

    private String name;

    private String dragdropId;

    private String description;

    private Boolean isbillable;

    private Long progress;

    private Integer position;

	private String createdBy;

	private ZonedDateTime createdDate = ZonedDateTime.now();

	private String lastModifiedBy;

	private ZonedDateTime lastModifiedDate = ZonedDateTime.now();

	private String status;
	
	private String domain;

    private Taskgroup taskgroup;

    public TaskDTO() {}
    
    public TaskDTO(Long id, String name, String status,String createdBy,
     ZonedDateTime createdDate , Integer position) {
        this.id=id;
        this.name=name;
        this.status=status;
        this.createdBy=createdBy;
        this.createdDate=createdDate;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isIsbillable() {
        return this.isbillable;
    }

    public Boolean getIsbillable() {
        return this.isbillable;
    }

    public void setIsbillable(Boolean isbillable) {
        this.isbillable = isbillable;
    }

    public Long getProgress() {
        return this.progress;
    }

    public void setProgress(Long progress) {
        this.progress = progress;
    }

    public Integer getPosition() {
        return this.position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }


    public String getDragdropId() {
        return this.dragdropId;
    }

    public void setDragdropId(String dragdropId) {
        this.dragdropId = dragdropId;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public ZonedDateTime getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return this.lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public ZonedDateTime getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public void setLastModifiedDate(ZonedDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Taskgroup getTaskgroup() {
        return this.taskgroup;
    }

    public void setTaskgroup(Taskgroup taskgroup) {
        this.taskgroup = taskgroup;
    }

    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TaskDTO)) {
            return false;
        }
        TaskDTO task = (TaskDTO) o;
        return Objects.equals(id, task.id) && Objects.equals(name, task.name) && Objects.equals(description, task.description) && Objects.equals(isbillable, task.isbillable) && Objects.equals(progress, task.progress) && Objects.equals(position, task.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, isbillable, progress, position);
    }


	@Override
	public String toString() {
		return "TaskDTO [id=" + id + ", name=" + name + ", dragdropId=" + dragdropId + ", description=" + description
				+ ", isbillable=" + isbillable + ", progress=" + progress + ", position=" + position + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate + ", lastModifiedBy=" + lastModifiedBy
				+ ", lastModifiedDate=" + lastModifiedDate + ", status=" + status + ", domain=" + domain
				+ ", taskgroup=" + taskgroup + "]";
	}
    

}
