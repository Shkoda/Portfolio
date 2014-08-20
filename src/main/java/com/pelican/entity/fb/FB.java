package com.pelican.entity.fb;

import lombok.ToString;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * Created by Nightingale on 17.08.2014.
 */
public class FB {
    @ToString
    public static class Picture implements Viewable {
        public final String URL;
        public final String uploadTime;

        public Picture(String URL, String uploadTime) {
            this.URL = URL;
            this.uploadTime = uploadTime;
        }

        @Override
        public ModelAndView update(ModelAndView modelAndView) {
            return modelAndView
                    .addObject("picture_url", URL)
                    .addObject("picture_upload_date", uploadTime);
        }
    }

    @ToString
    public static class BasicProfileData implements Viewable{
        public final String profileURL;
        public final String publicMail;
        public final Date birthday;
        public final String gender;

        public BasicProfileData(String profileURL, String publicMail, Date birthday, String gender) {
            this.profileURL = profileURL;
            this.publicMail = publicMail;
            this.birthday = birthday;
            this.gender = gender;
        }

//        @Override
//        public ModelAndView update(ModelAndView modelAndView) {
//            return modelAndView
//                    .addObject("profile_url", profileURL)
//                    .addObject("public_mail", publicMail)
//                    .addObject("birthday", birthday)
//                    .addObject("gender", gender);
//        }
    }


}
