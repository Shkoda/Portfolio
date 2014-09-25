package com.pelican.persistence.repository;

import com.pelican.persistence.domain.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

/**
* Created by Nightingale on 09.09.2014.
*/
public interface TaskRepository extends JpaRepository<Task, Serializable> {
    List<Task> findByOwnerId(int ownerId);

    Task findByIdAndOwnerId(int id, int ownerId);
}
