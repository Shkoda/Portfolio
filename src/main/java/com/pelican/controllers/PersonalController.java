package com.pelican.controllers;

import com.pelican.persistence.Task;
import com.pelican.service.TaskService;
import com.pelican.utils.Loggers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

/**
 * Created by Nightingale on 13.09.2014.
 */
@Controller
@RequestMapping("/user")
public class PersonalController {
    @Autowired
    @Qualifier(value = "taskService")
    private TaskService taskService;

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Principal principal) {
        String login = principal.getName();
        Loggers.debugLogger.debug(" >>>>>>>>>>>>>>>> " + login);
        List<Task> tasks = taskService.getTasks(login);
        for (Task task : tasks)         //todo !! эта тварь не понимает forEach...
            System.out.println(" >>>>>>>>>>>>>>>> " + task);
        return "user/dashboard";
    }
}
