package com.pelican.controllers;

import com.pelican.entity.FB;
import com.pelican.entity.FBCredentials;
import com.pelican.service.Facebook;
import com.pelican.service.FacebookExploration;
import com.pelican.utils.Loggers;
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Nightingale on 12.08.2014.
 */
@Controller
@SessionAttributes("credentials")
public class AppController {

    @ModelAttribute("credentials")
    public FBCredentials createCredentials() {
        return new FBCredentials();
    }

    @RequestMapping(value = {"/", "/fb_auth/auth_prompt"}, method = {RequestMethod.GET})
    public ModelAndView login(@ModelAttribute("credentials") FBCredentials credentials) {
        Loggers.debugLogger.debug(credentials);

        ModelAndView modelAndView = new ModelAndView("/fb_auth/auth_prompt");
        modelAndView.addObject("auth_uri", Facebook.getCodeRequestURI());

        return modelAndView;
    }

    @RequestMapping(value = {"/fb/authorization"}, method = {RequestMethod.GET})
    public ModelAndView fbAuth(@RequestParam(value = "code", required = false) String code, @ModelAttribute("credentials") FBCredentials credentials) {

        Loggers.debugLogger.debug("in fb auth");

        if (code == null || code.length() == 0)
            return redirectToFbAuthPage();

        try {
            OAuthClientRequest request = Facebook.getTokenRequestURI(code);
            OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
            GitHubTokenResponse oAuthResponse = oAuthClient.accessToken(request, GitHubTokenResponse.class);

            String accessToken = oAuthResponse.getAccessToken();
            credentials.setAccessToken(accessToken);

            return new ModelAndView("redirect:/general");

        } catch (OAuthProblemException | OAuthSystemException e) {
            e.printStackTrace();
            return redirectToFbErrorPage(e);
        }
    }


    @RequestMapping(value = {"/general"}, method = {RequestMethod.GET})
    public ModelAndView indexPage(@ModelAttribute("credentials") FBCredentials credentials) {

        Loggers.debugLogger.debug(credentials);

        FacebookClient facebookClient = new DefaultFacebookClient(credentials.getAccessToken());
        User user = facebookClient.fetchObject("me", User.class);

        ModelAndView model = new ModelAndView();
        model.addObject("first_name", user.getFirstName());
        model.addObject("last_name", user.getLastName());

        addProfilePicture(model);
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
        return new ModelAndView("redirect:" + Facebook.getCodeRequestURI());
    }
//
//    @RequestMapping(value = {"/helloworld**"}, method = {RequestMethod.GET})
//    public ModelAndView welcomePage() {
//        ModelAndView model = new ModelAndView();
//        model.addObject("title", "If you read this it works");
//        model.addObject("message", "Thank you for testing =)");
//        model.addObject("auth_uri", Facebook.getCodeRequestURI());
//        model.setViewName("helloworld");
//        Loggers.debugLogger.debug(model);
//        return model;
//    }
//
//    @RequestMapping(value = "/protected**", method = RequestMethod.GET)
//    public ModelAndView protectedPage() {
//
//        ModelAndView model = new ModelAndView();
//        model.addObject("title", "Spring Security 3.2.4 Hello World Tutorial");
//        model.addObject("message", "This is protected page - Only for Admin Users!");
//        model.setViewName("protected");
//        return model;
//
//    }
//
//    @RequestMapping(value = "/confidential**", method = RequestMethod.GET)
//    public ModelAndView adminPage() {
//
//        ModelAndView model = new ModelAndView();
//        model.addObject("title", "Spring Security 3.2.4 Hello World Tutorial");
//        model.addObject("message", "This is confidential page - Need Super Admin Role!");
//        model.setViewName("protected");
//
//        return model;
//
//    }
//
//    //Spring Security see this :
//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public ModelAndView login(
//            @RequestParam(value = "error", required = false) String error,
//            @RequestParam(value = "logout", required = false) String logout) {
//        Loggers.debugLogger.debug("in login controller");
//        ModelAndView model = new ModelAndView();
//        if (error != null) {
//            model.addObject("error", "Invalid username and password!");
//        }
//
//        if (logout != null) {
//            model.addObject("msg", "You've been logged out successfully.");
//        }
//        model.setViewName("login");
//
//        return model;
//
//    }


}
