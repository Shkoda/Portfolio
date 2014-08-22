package com.pelican.service;

import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.common.OAuthProviderType;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;

import java.util.Properties;

/**
 * Created by Nightingale on 13.08.2014.
 */
public class FacebookConf {
    private static String APP_ID, APP_SECRET;
    private static String REDIRECT_URI;
    private static String AUTH_REQUEST;
    public static final String FB_APP_CONFIG_PATH = "/application.properties";

    static {
        try {
            Properties properties = new Properties();
            properties.load(FacebookConf.class.getResourceAsStream(FB_APP_CONFIG_PATH));

            APP_ID = properties.getProperty("app_id");
            APP_SECRET = properties.getProperty("app_secret");
            REDIRECT_URI = properties.getProperty("redirect_uri");

            AUTH_REQUEST = OAuthClientRequest
                    .authorizationProvider(OAuthProviderType.FACEBOOK)
                    .setClientId(APP_ID)
                    .setRedirectURI(REDIRECT_URI)
                    .buildQueryMessage().getLocationUri();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(getCodeRequestURI());
    }

    public static String getCodeRequestURI() {
        return AUTH_REQUEST;
    }

    /**
     * @param code code obtained during first auth step
     */
    public static OAuthClientRequest getTokenRequestURI(String code) throws OAuthSystemException {
        return OAuthClientRequest
                .tokenProvider(OAuthProviderType.FACEBOOK)
                .setGrantType(GrantType.AUTHORIZATION_CODE)
                .setClientId(APP_ID)
                .setClientSecret(APP_SECRET)
                .setRedirectURI(REDIRECT_URI)
                .setCode(code)
                .buildQueryMessage();
    }
}
































