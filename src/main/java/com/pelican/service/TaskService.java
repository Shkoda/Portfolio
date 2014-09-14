package com.pelican.service;


import com.pelican.persistence.Task;

import java.util.List;

/**
 * Created by Nightingale on 13.09.2014.
 */
public interface TaskService {
    List<Task> getTasks(Integer ownerId);

    List<Task> getTasks(String login);
}
