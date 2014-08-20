package com.pelican.service;

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
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Nightingale on 18.08.2014.
 */
public class FbAuth {

    public static ModelAndView auth(String code) {
        if (code == null || code.length() == 0)
            return redirectToFbAuthPage();
        User user = null;
        try {
            OAuthClientRequest request = FacebookConf.getTokenRequestURI(code);

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
            return userData(user);

        } catch (OAuthProblemException | OAuthSystemException e) {
            e.printStackTrace();
            return redirectToFbErrorPage(e);
        }
    }

    private static ModelAndView userData(User user) {
        ModelAndView model = new ModelAndView("/general");
        model.addObject("first_name", user.getFirstName());
        model.addObject("last_name", user.getLastName());
        model.addObject("user", user);


        return model;
    }

    private static ModelAndView redirectToFbErrorPage(Exception e) {
        return new ModelAndView("fb/exception")
                .addObject("message", e.getMessage());
    }

    private static ModelAndView redirectToFbAuthPage() {
        return new ModelAndView("redirect:" + FacebookConf.getCodeRequestURI());
    }

}


































