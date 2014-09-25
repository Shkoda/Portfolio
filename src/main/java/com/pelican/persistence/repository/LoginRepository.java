package com.pelican.persistence.repository;

import com.pelican.persistence.domain.auth.LoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;

/**
 * Created by Nightingale on 22.08.2014.
 */
public interface LoginRepository extends JpaRepository<LoginInfo, Serializable> {
    LoginInfo findByLogin(String login);

//    @Query("select u from lo u where u.firstname = :firstname or u.lastname = :lastname")
//    Integer findIdByLogin(String login);
}
