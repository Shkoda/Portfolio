package com.pelican.service;

import com.google.gson.annotations.SerializedName;
import com.pelican.utils.DiskUtils;
import com.pelican.utils.GsonUtils;
import com.visural.common.StringUtil;
import lombok.Data;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.common.OAuthProviderType;

/**
 * Created by Nightingale on 13.08.2014.
 */
public class Facebook {
    private static String APP_ID, APP_SECRET;
    private static String REDIRECT_URI;
    private static String AUTH_REQUEST;
    public static final String APP_CONFIG_PATH = "conf/facebook.conf";

    static {
        try {
            Conf conf = GsonUtils.gson.fromJson(DiskUtils.readString(APP_CONFIG_PATH), Conf.class);
            APP_ID = conf.appId;
            APP_SECRET = conf.appSecret;
            REDIRECT_URI = conf.redirectUri;
            AUTH_REQUEST = OAuthClientRequest
                    .authorizationProvider(OAuthProviderType.FACEBOOK)
                    .setClientId(APP_ID)
                    .setRedirectURI(REDIRECT_URI)
                    .buildQueryMessage().getLocationUri();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static String getAuthRequestURI() {
        return AUTH_REQUEST;
    }

    public static void main(String[] args) {
        System.out.println(getAuthRequestURI());
    }
    @Data
    private class Conf {
        @SerializedName("app_id")
        private String appId;
        @SerializedName("app_secret")
        private String appSecret;
        @SerializedName("redirect_uri")
        private String redirectUri;
    }
}
































