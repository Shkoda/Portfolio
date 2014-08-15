package com.pelican.controllers;

import com.pelican.service.Facebook;
import com.pelican.utils.Loggers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Nightingale on 12.08.2014.
 */
@Controller
public class AppController {

    @RequestMapping(value = {"/", "/helloworld**"}, method = {RequestMethod.GET})
    public ModelAndView welcomePage() {
        ModelAndView model = new ModelAndView();
        model.addObject("title", "If you read this it works");
        model.addObject("message", "Thank you for testing =)");
        model.addObject("auth_uri", Facebook.getCodeRequestURI());
        model.setViewName("helloworld");
        Loggers.debugLogger.debug(model);
        return model;
    }

    @RequestMapping(value = "/protected**", method = RequestMethod.GET)
    public ModelAndView protectedPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security 3.2.4 Hello World Tutorial");
        model.addObject("message", "This is protected page - Only for Admin Users!");
        model.setViewName("protected");
        return model;

    }

    @RequestMapping(value = "/confidential**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security 3.2.4 Hello World Tutorial");
        model.addObject("message", "This is confidential page - Need Super Admin Role!");
        model.setViewName("protected");

        return model;

    }

    //Spring Security see this :
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {
        Loggers.debugLogger.debug("in login controller");
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

    }

    @RequestMapping(value = "/facebook_init_error", method = RequestMethod.GET)
    public ModelAndView facebookInitErrorPage() {
        return new ModelAndView();
    }
}
