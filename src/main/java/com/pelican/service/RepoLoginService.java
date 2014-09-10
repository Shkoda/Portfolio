package com.pelican.service;

import com.pelican.persistence.LoginInfo;
import com.pelican.persistence.repository.LoginRepository;
import com.pelican.utils.Loggers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Nightingale on 22.08.2014.
 */
@Service
//@Transactional
@EnableAutoConfiguration
//@Configuration
//@ComponentScan("com.pelican.persistence.repository")
public class RepoLoginService implements LoginService {
    @Autowired
    private LoginRepository loginRepository;

    @Transactional
    @Override
    public void save(LoginInfo info) {
        List<LoginInfo> all = loginRepository.findAll();

        all.forEach(Loggers.debugLogger::debug);

        Loggers.debugLogger.debug("saving " + info + "...");
        loginRepository.saveAndFlush(info);
    }
}
