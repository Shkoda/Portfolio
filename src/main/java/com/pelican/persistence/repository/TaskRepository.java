package com.pelican.persistence.repository;

import com.pelican.persistence.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;
import java.util.List;

/**
* Created by Nightingale on 09.09.2014.
*/
public interface TaskRepository extends JpaRepository<Task, Serializable> {
    List<Task> findByOwnerId(int ownerId);
}
