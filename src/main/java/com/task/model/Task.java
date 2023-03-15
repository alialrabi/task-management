package com.task.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Task extends Metadata {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 3, max = 100)
    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Size(max = 255)
    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "isbillable")
    private Boolean isbillable;

    @Column(name = "progress")
    private Long progress;

    @Column(name = "position")
    private Integer position;

    @ManyToOne
    private Taskgroup taskgroup;

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
        if (!(o instanceof Task)) {
            return false;
        }
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(name, task.name)
                && Objects.equals(description, task.description) && Objects.equals(isbillable, task.isbillable)
                && Objects.equals(progress, task.progress) && Objects.equals(position, task.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, isbillable, progress, position);
    }

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", description=" + description + ", isbillable=" + isbillable
				+ ", progress=" + progress + ", position=" + position + ", taskgroup=" + taskgroup + "]";
	}

    

}
