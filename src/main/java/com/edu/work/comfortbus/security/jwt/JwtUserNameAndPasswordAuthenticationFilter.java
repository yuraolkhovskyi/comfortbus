package com.edu.work.comfortbus.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.SneakyThrows;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class JwtUserNameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public JwtUserNameAndPasswordAuthenticationFilter(final AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(final HttpServletRequest request,
                                                final HttpServletResponse response) throws AuthenticationException {

        final var authRequest =
                new ObjectMapper().readValue(request.getInputStream(), UsernameAndPasswordAuthenticationRequestDTO.class);

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                authRequest.getUsername(),
                authRequest.getPassword()
        );
        authenticationManager.authenticate(authentication);

        return super.attemptAuthentication(request, response);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        final String key = "secure";
        final String token = Jwts.builder()
                .setSubject(authResult.getName())
                .claim("authorities", authResult.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusWeeks(2)))
                .signWith(Keys.hmacShaKeyFor(key.getBytes())).compact();

        response.addHeader("Authorization", "Bearer " + token);
    }
}
