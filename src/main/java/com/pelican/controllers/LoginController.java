package com.pelican.controllers;

import com.pelican.persistence.LoginInfo;
import com.pelican.persistence.repository.LoginRepository;
import com.pelican.service.LoginService;
import com.pelican.service.RepoLoginService;
import com.pelican.utils.Loggers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

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

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private Environment env;

    @RequestMapping(value = {"/", "/login"}, method = {RequestMethod.GET})
    public ModelAndView loginPrompt() {
        Loggers.debugLogger.debug("in login controller");
        return new ModelAndView("login");
    }

//    @RequestMapping(value = "get_user_name", method = RequestMethod.GET)
//    public String getUserName(){
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//      return user.getUsername(); //get logged in username
//    }

    @RequestMapping(value = {"/registration"}, method = {RequestMethod.GET})
    public ModelAndView registerPrompt() {
        return new ModelAndView();
    }

//    @RequestMapping(value = {"/submit_registration"}, method = {RequestMethod.GET})
//    public ModelAndView refreshRegisterSubmit(){
//        return new ModelAndView("redirect:user/welcome");
//    }

    @RequestMapping(value = {"/submit_registration"}, method = {RequestMethod.POST})
    public ModelAndView registerCheckLogin(@RequestParam(value = "username", required = false) String login,
                                           @RequestParam(value = "password", required = false) String pass,
                                           @RequestParam(value = "password_repeat", required = false) String passCheck) {
        if (login == null || login.isEmpty())
            return new ModelAndView("redirect:registration").addObject("error", "Please fill login field");

        if (pass == null || passCheck == null || pass.isEmpty() || passCheck.isEmpty())
            return new ModelAndView("redirect:registration").addObject("error", "Password is required");

        if (!pass.equals(passCheck))
            return new ModelAndView("redirect:registration").addObject("error", "Password check doesn't match");

        if (loginRepository.findByLogin(login) != null)
            return new ModelAndView("redirect:registration").addObject("error", "Login is already in use");

        LoginInfo loginInfo = new LoginInfo(login, encoder.encode(pass));
//        loginRepository.saveAndFlush(new LoginInfo(login, encoder.encode(pass)));
        loginService.save(loginInfo);
        return new ModelAndView("redirect:user/welcome").addObject("login", login);
    }
}








































