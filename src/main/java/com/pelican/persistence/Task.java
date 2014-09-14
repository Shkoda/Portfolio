package com.pelican.persistence;

import com.pelican.core.event.task.TaskDetails;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    public String description;
//    @Column(name = "creation_time")
//    private LocalDateTime createdAt;
//    @Column(name = "start_time")
//    private LocalDateTime startAt;
//    @Column(name = "expiration_time")
//    private LocalDateTime finishAt;
    @Column(name = "owner_id", nullable = false)
    private int ownerId;

    public Task(String description, int ownerId) {
        this.description = description;
        this.ownerId = ownerId;
    }

    //
//    public static Task fromDetails(TaskDetails details) {
//        Task task = new Task();
//        task.id = details.getTaskId();
//        task.createdAt = details.getSubmission();
//        return task;
//    }


}
