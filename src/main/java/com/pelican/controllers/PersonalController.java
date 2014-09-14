package com.pelican.controllers;

import com.pelican.utils.Loggers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Created by Nightingale on 13.09.2014.
 */
@Controller
@RequestMapping("/user")
public class PersonalController {
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Principal principal) {
        Loggers.debugLogger.debug(" >>>>>>>>>>>>>>>> "+principal.getName());
        return "user/dashboard";
    }
}
