package com.pelican.service;

import com.pelican.persistence.domain.auth.LoginInfo;
import com.pelican.persistence.domain.task.Tag;
import com.pelican.persistence.domain.task.Task;
import com.pelican.persistence.repository.LoginRepository;
import com.pelican.persistence.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nightingale on 13.09.2014.
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private LoginRepository loginRepository;

    @Override
    public List<Tag> getTags(String login) {
        return null;
    }

    @Override
    public List<Task> getTasks(String login) {
        LoginInfo info = loginRepository.findByLogin(login);
        return getTasks(info == null ? null : info.getId());

//        return getTasks(loginRepository.findIdByLogin(login));

    }



    @Override
    @Transactional
    public List<Task> getTasks(Integer ownerId) {
        return ownerId == null ? new ArrayList<>() : taskRepository.findByOwnerId(ownerId);
    }

    @Override
    public Task getTask(Integer ownerId, int taskId) {
        return ownerId == null ? null : taskRepository.findByIdAndOwnerId(taskId, ownerId);
    }

    @Override
    public Task getTask(String login, int taskId) {
        LoginInfo info = loginRepository.findByLogin(login);
        return getTask(info == null ? null : info.getId(), taskId);
    }
}
