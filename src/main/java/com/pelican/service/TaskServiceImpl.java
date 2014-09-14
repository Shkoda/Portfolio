package com.pelican.service;

import com.pelican.persistence.Task;
import com.pelican.persistence.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Nightingale on 13.09.2014.
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    @Transactional
    public List<Task> getTasks(int ownerId) {
        return taskRepository.findByOwnerId(ownerId);
    }
}
