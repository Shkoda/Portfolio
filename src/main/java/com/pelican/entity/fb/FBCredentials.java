package com.pelican.entity.fb;

import lombok.Data;
import lombok.ToString;

/**
 * Created by Nightingale on 20.08.2014.
 */
@ToString
public class FBCredentials {
    private String accessToken;

    public FBCredentials() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
