package com.pelican.persistence.domain.task;

import com.pelican.core.event.task.TaskDetails;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
* Created by Nightingale on 09.09.2014.
*/
@Data
@NoArgsConstructor
@Entity
@Table(schema = "planner", name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "creation_time")
    private Date createdAt;
    @Column(name = "start_time")
    private Date startAt;
    @Column(name = "expiration_time")
    private Date finishAt;
    @Column(name = "owner_id", nullable = false)
    private int ownerId;

    public Task(String description, int ownerId) {
        this.description = description;
        this.ownerId = ownerId;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getStartAt() {
        return startAt;
    }

    public Date getFinishAt() {
        return finishAt;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public int getId() {
        return id;
    }

    //
//    public static Task fromDetails(TaskDetails details) {
//        Task task = new Task();
//        task.id = details.getTaskId();
//        task.createdAt = details.getSubmission();
//        return task;
//    }


}
