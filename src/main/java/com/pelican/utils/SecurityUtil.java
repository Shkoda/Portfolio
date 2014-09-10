package com.pelican.utils;

import com.pelican.persistence.LoginInfo;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by Nightingale on 10.09.2014.
 */
public class SecurityUtil {

    public static void logInUser(String login, String password) {
//        ExampleUserDetails userDetails = ExampleUserDetails.getBuilder()
//                .firstName(user.getFirstName())
//                .id(user.getId())
//                .lastName(user.getLastName())
//                .password(user.getPassword())
//                .role(user.getRole())
//                .socialSignInProvider(user.getSignInProvider())
//                .username(user.getEmail())
//                .build();

        Authentication authentication = new UsernamePasswordAuthenticationToken(login, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

}
