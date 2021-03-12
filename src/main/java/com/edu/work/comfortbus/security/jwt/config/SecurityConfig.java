package com.edu.work.comfortbus.security.jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.edu.work.comfortbus.domain.enumeration.UserPermission.RIDE_READ;
import static com.edu.work.comfortbus.domain.enumeration.UserRole.ADMIN;
import static com.edu.work.comfortbus.domain.enumeration.UserRole.CLIENT;

@Configuration
@EnableWebSecurity
@Order(1000)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(final PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/api/comment/**").hasRole(CLIENT.name())
                .antMatchers(HttpMethod.GET, "/api/ride/**").hasAuthority(RIDE_READ.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

//        http
//                .csrf().disable()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .addFilter(new JwtUserNameAndPasswordAuthenticationFilter(authenticationManager()))
//                .addFilterAfter(new JwtTokenVerifier(), JwtUserNameAndPasswordAuthenticationFilter.class)
//                .authorizeRequests()
//                .antMatchers("/api/**").hasRole(UserRole.ADMIN.name())
//                .anyRequest()
//                .authenticated();
    }


    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        final var userDetails1 = User.builder()
                .username("Anna")
                .password(passwordEncoder.encode("password"))
                .authorities(CLIENT.getGrantedAuthorities())
                .build();

        final var userDetails2 = User.builder()
                .username("Linda")
                .password(passwordEncoder.encode("password123"))
                .authorities(ADMIN.getGrantedAuthorities())
                .build();

        return new InMemoryUserDetailsManager(
                userDetails1,
                userDetails2
        );


    }

}
