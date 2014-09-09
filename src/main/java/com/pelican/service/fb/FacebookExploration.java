package com.pelican.service.fb;

import com.pelican.entity.fb.FB;

/**
 * Created by Nightingale on 17.08.2014.
 */
public class FacebookExploration {
    private static final String TOKEN = "CAACEdEose0cBAAlqKgNAfgPM5ZAS3AVyJmyxYBSlu23PT451imZBhZC3d6JSLPZCCUsgZC1PAtr2qvCKBHD7wBKcuKKgQQUGYPIZA9CmUiRmfj6TjLbjMlCn16g2S8cYZBItE55xx2AdMooRKCOUOVszPerZC6PhGtXsR4IKZBxR0RkTjTc4X7ecOMYKSjFXXKzM1sOutG5xi0wcnMqYDDkDefnmVd3I8xl8ZD";

    public static FB.Picture getProfilePicture() {
//        FacebookClient facebookClient = new DefaultFacebookClient(MY_ACCESS_TOKEN);
//        User user = facebookClient.fetchObject("me", User.class);
        return new FB.Picture("https://www.dropbox.com/s/7chpl7pyywq69vh/Chiara-Bautista-aka-Milk-2.jpg", "13 февраля 2014 г. в 14:15 UTC+02");
    }
}
