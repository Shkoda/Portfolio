package com.pelican.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class WebController {

    @RequestMapping(value = {"/","/example"}, method = RequestMethod.GET)
    public String examplePage(ModelMap model){
        return "example";
    }

}