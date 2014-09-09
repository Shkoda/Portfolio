package com.pelican.persistence;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Nightingale on 22.08.2014.
 */
@Data
@Entity
@Table(name="users.auth")
public class LoginInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false, unique = true)
    private String login;
    @Column(name = "password_hash", nullable = false, unique = true)
    private String passwordHash;

    public LoginInfo(String login, String passwordHash) {
        this.login = login;
        this.passwordHash = passwordHash;
    }

    public LoginInfo() {
    }
}
