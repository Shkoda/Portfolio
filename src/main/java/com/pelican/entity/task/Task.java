package com.pelican.entity.task;

import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Created by Nightingale on 20.08.2014.
 */
@ToString
public class Task {
    private int id;
    public String description;
    private LocalDateTime createdAt;
    private LocalDateTime startAt;
    private LocalDateTime finishAt;

    public Task(int id, String description, LocalDateTime createdAt, LocalDateTime startAt, LocalDateTime finishAt) {
        this.id = id;
        this.description = description;
        this.createdAt = createdAt;
        this.startAt = startAt;
        this.finishAt = finishAt;
    }

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getStartAt() {
        return startAt;
    }

    public void setStartAt(LocalDateTime startAt) {
        this.startAt = startAt;
    }

    public LocalDateTime getFinishAt() {
        return finishAt;
    }

    public void setFinishAt(LocalDateTime finishAt) {
        this.finishAt = finishAt;
    }
}
