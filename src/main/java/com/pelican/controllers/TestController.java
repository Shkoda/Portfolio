package com.pelican.controllers;

import com.pelican.entity.LoginInfo;
import com.pelican.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Nightingale on 22.08.2014.
 */
@Controller
public class TestController {
 //   private static LoginService loginService;
//
//    @Autowired
//    public static void setLoginService(LoginService loginService) {
//        TestController.loginService = loginService;
//    }
//
//    @RequestMapping(value = {"testjpa"}, method = {RequestMethod.GET})
//    public ModelAndView testJPA() {
//        ModelAndView modelAndView = new ModelAndView();
//        List<LoginInfo> all = loginService.findAll();
//        modelAndView.addObject("info", all);
//        return modelAndView;
//    }
}
