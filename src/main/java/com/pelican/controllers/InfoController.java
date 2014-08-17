package com.pelican.controllers;

import com.pelican.entity.FB;
import com.pelican.service.FacebookExploration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Nightingale on 17.08.2014.
 */
@Controller
public class InfoController {
    @RequestMapping(value = {"/", "/index"}, method = {RequestMethod.GET})
    public ModelAndView indexPage() {
        ModelAndView model = new ModelAndView("index");
        addProfilePicture(model);

        return model;
    }

    private ModelAndView addProfilePicture(ModelAndView model) {
        FB.Picture picture = FacebookExploration.getProfilePicture();
        model.addObject("picture_url", picture.URL);
        model.addObject("picture_upload_date", picture.uploadTime);
        return model;
    }
}
