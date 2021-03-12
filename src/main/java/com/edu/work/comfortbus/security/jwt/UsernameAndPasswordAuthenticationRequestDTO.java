package com.edu.work.comfortbus.security.jwt;

import lombok.Data;

@Data
public class UsernameAndPasswordAuthenticationRequestDTO {

    private String username;
    private String password;

}
