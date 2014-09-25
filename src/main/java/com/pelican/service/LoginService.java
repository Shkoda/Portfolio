package com.pelican.service;

import com.pelican.persistence.domain.auth.LoginInfo;

/**
 * Created by Nightingale on 10.09.2014.
 */
public interface LoginService {
    void save(LoginInfo info);

    boolean isAlreadyRegistered(String login);

}
