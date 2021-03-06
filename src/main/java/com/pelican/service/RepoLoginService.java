package com.pelican.service;

import com.pelican.persistence.domain.auth.LoginInfo;
import com.pelican.persistence.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class RepoLoginService implements LoginService {
    @Autowired
    private LoginRepository loginRepository;

    @Override
    @Transactional
    public void save(LoginInfo info) {
        loginRepository.saveAndFlush(info);
    }

    @Override
    public boolean isAlreadyRegistered(String login) {
        return loginRepository.findByLogin(login) != null;
    }
}
