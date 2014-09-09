//package com.pelican.persistence.domain;
//
//import com.pelican.core.event.task.TaskDetails;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import java.time.LocalDateTime;
//
///**
// * Created by Nightingale on 09.09.2014.
// */
//@Entity(name = "planner.tasks")
//public class Task {
//    @Id
//    private int id;
//    @Column
//    public String description;
//    @Column(name = "creation_time")
//    private LocalDateTime createdAt;
//    @Column(name = "start_time")
//    private LocalDateTime startAt;
//    @Column(name = "expiration_time")
//    private LocalDateTime finishAt;
//
//    public static Task fromDetails(TaskDetails details){
//        Task task = new Task();
//        task.id = details.getTaskId();
//        task.createdAt = details.getSubmission();
//        return task;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public LocalDateTime getStartAt() {
//        return startAt;
//    }
//
//    public void setStartAt(LocalDateTime startAt) {
//        this.startAt = startAt;
//    }
//
//    public LocalDateTime getFinishAt() {
//        return finishAt;
//    }
//
//    public void setFinishAt(LocalDateTime finishAt) {
//        this.finishAt = finishAt;
//    }
//}
