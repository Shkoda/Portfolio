package com.pelican.core.domain.task;

import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Created by Nightingale on 09.09.2014.
 */
@ToString
public class TaskStatus {
    private String description;
    private LocalDateTime time;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
