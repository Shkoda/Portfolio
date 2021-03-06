package com.pelican.service;


import com.pelican.persistence.domain.task.Tag;
import com.pelican.persistence.domain.task.Task;

import java.util.List;

/**
 * Created by Nightingale on 13.09.2014.
 */
public interface TaskService {
    List<Task> getTasks(Integer ownerId);

    List<Task> getTasks(String login);

    Task getTask(Integer ownerId, int taskId);

    Task getTask(String login, int taskId);

    List<Tag> getTags(String login);


}
