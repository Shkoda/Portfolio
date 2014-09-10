package com.pelican.persistence;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Nightingale on 22.08.2014.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "users.auth")
public class LoginInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "login", nullable = false, unique = true)
    private String login;
    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    public LoginInfo(String login, String passwordHash) {
        this.login = login;
        this.passwordHash = passwordHash;
    }

}
