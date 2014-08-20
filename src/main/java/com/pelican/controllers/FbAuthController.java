package com.pelican.controllers;

import com.pelican.service.Facebook;
import com.pelican.service.FbAuth;
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
@RequestMapping(value = "/fb")
public class FbAuthController {
    @RequestMapping(value = {"/authorization"}, method = {RequestMethod.GET})
    public ModelAndView fbAuth(@RequestParam(value = "code", required = false) String code) {
        Loggers.debugLogger.debug("in fb auth");
        return FbAuth.auth(code);
    }

}
