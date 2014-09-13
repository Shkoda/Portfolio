package com.pelican.entity;

import com.pelican.service.LoginService;
import com.pelican.utils.validation.NotEmptyStringFieldMatch;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.inject.Inject;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;

/**
 * Created by Nightingale on 10.09.2014.
 */
@Data
@NoArgsConstructor
@NotEmptyStringFieldMatch(first = "password", second = "passwordDuplicate", message = "The password fields must match")
public class RegistrationForm {
    @NotEmpty(message = "Enter login")
    private String username;
    @NotEmpty(message = "Enter password")
    private String password;
    @NotEmpty(message = "Retype password")
    private String passwordDuplicate;


    public RegistrationForm(String username, String password, String passwordDuplicate) {
        this.username = username;
        this.password = password;
        this.passwordDuplicate = passwordDuplicate;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
