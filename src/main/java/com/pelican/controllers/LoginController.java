package com.pelican.controllers;

import com.pelican.entity.RegistrationForm;
import com.pelican.persistence.LoginInfo;
import com.pelican.service.LoginService;
import com.pelican.utils.Loggers;
import com.pelican.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Nightingale on 09.09.2014.
 */
@Controller
public class LoginController {
    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    @Qualifier(value = "loginService")
    private LoginService loginService;

    @RequestMapping(value = {"/", "/login"}, method = {RequestMethod.GET})
    public String loginPrompt() {
        Loggers.debugLogger.debug("in login controller");
        return "/login";
    }

    @RequestMapping(value = {"/registration"}, method = {RequestMethod.GET})
    public ModelAndView registerPrompt() {
        return new ModelAndView();
    }

    @RequestMapping(value = {"/submit_registration"}, method = {RequestMethod.POST})
    public ModelAndView registerCheckLogin(@Valid RegistrationForm registrationForm, BindingResult result) {

        if (result.hasErrors())
            return redirectToRegistration(result.getAllErrors().get(0).getDefaultMessage());
        String login = registrationForm.getUsername();
        if (loginService.isAlreadyRegistered(login))
            return redirectToRegistration("Login is already in use");

        String password = registrationForm.getPassword();
        loginService.save(new LoginInfo(login, encoder.encode(password)));
        SecurityUtil.logInUser(login, password);
        return redirectToPersonalPage();
    }

    private ModelAndView redirectToRegistration(String errorMessage) {
        return new ModelAndView("redirect:registration")
                .addObject("error", errorMessage);
    }

    private ModelAndView redirectToPersonalPage() {
        return new ModelAndView("redirect:user/welcome");
    }

}








































