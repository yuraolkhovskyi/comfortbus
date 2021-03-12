package com.edu.work.comfortbus.security.jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static java.math.BigInteger.TEN;

@Configuration
public class PasswordConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(TEN.intValue());
    }

}
