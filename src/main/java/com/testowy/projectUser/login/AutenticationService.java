package com.testowy.projectUser.login;

import org.springframework.stereotype.Service;

@Service
public class AutenticationService {

    public boolean autentication(String username, String password){
       boolean isValidUserName =  "gosia".equalsIgnoreCase(username);
       boolean isValidPassword= "password".equalsIgnoreCase(password);

        return isValidUserName && isValidPassword;

    }
}
