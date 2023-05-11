package com.example.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {

    public boolean authenticate(String username, String password) {
        boolean isValidUserName = username.equalsIgnoreCase("name");
        boolean isValidPassword = password.equalsIgnoreCase("pass");

        return isValidUserName && isValidPassword;
    }
}
