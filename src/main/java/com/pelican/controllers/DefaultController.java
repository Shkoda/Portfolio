package com.pelican.controllers;

import com.pelican.entity.fb.FB;
import com.pelican.entity.fb.FBCredentials;
import com.pelican.service.fb.FacebookConf;
import com.pelican.service.fb.FacebookExploration;
import com.pelican.utils.Loggers;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.User;
import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.GitHubTokenResponse;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Nightingale on 12.08.2014.
 */
@Controller
@SessionAttributes({"credentials", "user"})
public class DefaultController {

    @ModelAttribute("credentials")
    public FBCredentials createCredentials() {
        Loggers.debugLogger.debug("Creating empty credentials holder...");
        return new FBCredentials();
    }

    @ModelAttribute("user")
    public User createUser() {
        Loggers.debugLogger.debug("Creating new user");
        return new User();
    }

    @RequestMapping(value = { "/fb_auth/auth_prompt"}, method = {RequestMethod.GET})
    public ModelAndView login(@ModelAttribute("credentials") FBCredentials credentials) {
        Loggers.debugLogger.debug("Login page :: "+credentials);

        ModelAndView modelAndView = new ModelAndView("/fb_auth/auth_prompt");
        modelAndView.addObject("auth_uri", FacebookConf.getCodeRequestURI());

        return modelAndView;
    }

    @RequestMapping(value = {"/fb/authorization"}, method = {RequestMethod.GET})
    public ModelAndView fbAuth(@RequestParam(value = "code", required = false) String code, @ModelAttribute("credentials") FBCredentials credentials) {
        Loggers.debugLogger.debug("Fb auth :: "+credentials);

        if (code == null || code.length() == 0)
            return redirectToFbAuthPage();

        try {
            OAuthClientRequest request = FacebookConf.getTokenRequestURI(code);
            OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
            GitHubTokenResponse oAuthResponse = oAuthClient.accessToken(request, GitHubTokenResponse.class);

            String accessToken = oAuthResponse.getAccessToken();
            credentials.setAccessToken(accessToken);

            return new ModelAndView("redirect:/my/general");

        } catch (OAuthProblemException | OAuthSystemException e) {
            e.printStackTrace();
            return redirectToFbErrorPage(e);
        }
    }


    @RequestMapping(value = {"/my/general"}, method = {RequestMethod.GET})
    public ModelAndView generalPage(@ModelAttribute("credentials") FBCredentials credentials, @ModelAttribute("user") User user) {
        Loggers.debugLogger.debug("General page :: "+credentials);

        FacebookClient facebookClient = new DefaultFacebookClient(credentials.getAccessToken());
        user = facebookClient.fetchObject("me", User.class);
        System.out.println(user+"\n\n");

        ModelAndView model = new ModelAndView();
        model.addObject("first_name", user.getFirstName());
        model.addObject("last_name", user.getLastName());


        Connection<User> myFriends = facebookClient.fetchConnection("me/friends", User.class);
        List<User> friendList = myFriends.getData();

        return model;
    }

    private ModelAndView addProfilePicture(ModelAndView model) {
        FB.Picture picture = FacebookExploration.getProfilePicture();
        model.addObject("picture_url", picture.URL);
        model.addObject("picture_upload_date", picture.uploadTime);
        return model;
    }

    @RequestMapping(value = "/fb/init_error", method = RequestMethod.GET)
    public ModelAndView facebookInitErrorPage() {
        return new ModelAndView();
    }

    private static ModelAndView redirectToFbErrorPage(Exception e) {
        return new ModelAndView("fb/exception")
                .addObject("message", e.getMessage());
    }

    private static ModelAndView redirectToFbAuthPage() {
        return new ModelAndView("redirect:" + FacebookConf.getCodeRequestURI());
    }

    @RequestMapping(value = "/user/welcome", method = RequestMethod.GET)
    public ModelAndView authorizationSuccess(){
        return new ModelAndView();
    }

}
