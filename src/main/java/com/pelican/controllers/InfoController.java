package com.pelican.controllers;

import com.pelican.entity.FB;
import com.pelican.entity.FBCredentials;
import com.pelican.service.FacebookExploration;
import com.pelican.utils.Loggers;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Nightingale on 17.08.2014.
 */
@Controller

public class InfoController {
//    @RequestMapping(value = {"/general"}, method = {RequestMethod.GET})
//    public ModelAndView indexPage(FBCredentials credentials) {
//
//        Loggers.debugLogger.debug(credentials);
//
//        FacebookClient facebookClient = new DefaultFacebookClient(credentials.getAccessToken());
//        User user = facebookClient.fetchObject("me", User.class);
//
//        ModelAndView model = new ModelAndView();
//        model.addObject("first_name", user.getFirstName());
//        model.addObject("last_name", user.getLastName());
//
//        addProfilePicture(model);
//        return model;
//    }
//
//    private ModelAndView addProfilePicture(ModelAndView model) {
//        FB.Picture picture = FacebookExploration.getProfilePicture();
//        model.addObject("picture_url", picture.URL);
//        model.addObject("picture_upload_date", picture.uploadTime);
//        return model;
//    }
}
