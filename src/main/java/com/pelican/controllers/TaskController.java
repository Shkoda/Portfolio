package com.pelican.controllers;

import com.pelican.persistence.Task;
import com.pelican.service.TaskService;
import com.pelican.utils.Loggers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

/**
 * Created by Nightingale on 13.09.2014.
 */
@Controller
@RequestMapping("/user")
public class TaskController {
    @Autowired
    @Qualifier(value = "taskService")
    private TaskService taskService;

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public void dashboard(Principal principal) {
        String login = principal.getName();
        Loggers.debugLogger.debug(" >>>>>>>>>>>>>>>> " + login);
        List<Task> tasks = taskService.getTasks(login);
        for (Task task : tasks)         //todo !! эта тварь не понимает forEach...
            System.out.println(" >>>>>>>>>>>>>>>> " + task);
    }

    @RequestMapping(value = "/all_tasks", method = RequestMethod.GET)
    public ModelAndView tasks(Principal principal) {
        List<Task> tasks = taskService.getTasks(principal.getName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tasks", tasks);
        return modelAndView;
    }

    @RequestMapping(value = "/task")
    public Task task(@RequestParam("task_id") int taskId, Principal principal) {
       return taskService.getTask(principal.getName(), taskId);

    }


}






















































