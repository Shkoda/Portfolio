package com.pelican.controllers;

import com.pelican.persistence.domain.task.Task;
import com.pelican.service.TaskService;
import com.pelican.utils.Loggers;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
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

    @Value("classpath:navigation.html")
    private Resource NAVIGATION_HTML;

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

    @RequestMapping(value = "/navigation", method = RequestMethod.GET)
    public ResponseEntity<String> navigation() {
//        String s = "<div>starnge test</div>" +
//                "<div>starnge test</div>" +
//                "<div>starnge test</div>";
        ResponseEntity<String> responseEntity ;
        try {
            responseEntity = new ResponseEntity<>(IOUtils.toString(NAVIGATION_HTML.getInputStream()), HttpStatus.OK);
        } catch (IOException e) {
            responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return responseEntity;
    }


}






















































