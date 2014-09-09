package com.pelican.core.event.task;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by Nightingale on 09.09.2014.
 */
public class TaskDetails {
    private int taskId;
    private LocalDateTime submission;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public LocalDateTime getSubmission() {
        return submission;
    }

    public void setSubmission(LocalDateTime submission) {
        this.submission = submission;
    }
}
