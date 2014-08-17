package com.pelican.service;

import com.pelican.entity.FB;

/**
 * Created by Nightingale on 17.08.2014.
 */
public class FacebookExploration {
    private static final String TOKEN = "CAACEdEose0cBAAlqKgNAfgPM5ZAS3AVyJmyxYBSlu23PT451imZBhZC3d6JSLPZCCUsgZC1PAtr2qvCKBHD7wBKcuKKgQQUGYPIZA9CmUiRmfj6TjLbjMlCn16g2S8cYZBItE55xx2AdMooRKCOUOVszPerZC6PhGtXsR4IKZBxR0RkTjTc4X7ecOMYKSjFXXKzM1sOutG5xi0wcnMqYDDkDefnmVd3I8xl8ZD";

    public static FB.Picture getProfilePicture() {
        return new FB.Picture("https://fbcdn-sphotos-g-a.akamaihd.net/hphotos-ak-xfa1/t1.0-9/1656417_365074190300935_2051843464_n.jpg", "13 февраля 2014 г. в 14:15 UTC+02");
    }
}
