package com.pelican.persistence.repository;

import com.pelican.persistence.LoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by Nightingale on 22.08.2014.
 */
public interface LoginRepository extends JpaRepository<LoginInfo, Serializable> {
    LoginInfo findByLogin(String login);
}
