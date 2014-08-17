package com.pelican.controllers;

import com.pelican.service.Facebook;
import com.pelican.utils.Loggers;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Post;
import com.restfb.types.User;
import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.GitHubTokenResponse;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Nightingale on 15.08.2014.
 */
@Controller
public class FbAuthController {
    @RequestMapping(value = {"/fb"}, method = {RequestMethod.GET})
    public ModelAndView fbAuth(@RequestParam(value = "code", required = false) String code) {
        if (code == null)
            return redirectToFbAuthPage();

        User user = null;
        try {
            OAuthClientRequest request = Facebook.getTokenRequestURI(code);

            Loggers.debugLogger.debug(request.getLocationUri());
            //create OAuth client that uses custom http client under the hood
            OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());

            //Facebook is not fully compatible with OAuth 2.0 draft 10, access token response is
            //application/x-www-form-urlencoded, not json encoded so we use dedicated response class for that
            //Custom response classes are an easy way to deal with oauth providers that introduce modifications to
            //OAuth 2.0 specification
            GitHubTokenResponse oAuthResponse = oAuthClient.accessToken(request, GitHubTokenResponse.class);

            String accessToken = oAuthResponse.getAccessToken();

            FacebookClient facebookClient = new DefaultFacebookClient(accessToken);
            user = facebookClient.fetchObject("me", User.class);

        } catch (OAuthSystemException | OAuthProblemException e) {
            e.printStackTrace();
        }

        return buildModelAndView(user);
    }

    private static ModelAndView redirectToFbAuthPage() {
        return new ModelAndView("redirect:" + Facebook.getCodeRequestURI());
    }

    private static ModelAndView buildModelAndView(User user) {
        ModelAndView model = new ModelAndView();
        model.addObject("first_name", user.getFirstName());
        model.addObject("last_name", user.getLastName());
        model.addObject("user", user);


        return model;
    }

}
