package com.pelican.service;

import com.pelican.entity.LoginInfo;
import com.pelican.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Nightingale on 22.08.2014.
 */
//@Service
//@Transactional
@EnableAutoConfiguration
@Configuration
//@ComponentScan("com.pelican.repositories")
public class LoginService {
//    @Autowired
//    private LoginRepository loginRepository;
//
//    public Iterable<LoginInfo> findAll() {
//        //return userDao.findAll();
//        return loginRepository.findAll();
//    }

}
