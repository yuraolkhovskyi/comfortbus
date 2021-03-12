package com.edu.work.comfortbus.security.jwt;

import com.google.common.base.Strings;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class JwtTokenVerifier extends OncePerRequestFilter {



    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws IOException, ServletException {

        String authorizationHeader = request.getHeader("Authorization");

        if (Strings.isNullOrEmpty(authorizationHeader) || !authorizationHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            String token = authorizationHeader.replace("Bearer ", "");
            final String secretKey = "secure";


            Jws<Claims> claimsJws = Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
                    .build()
                    .parseClaimsJws(token);

            Claims body = claimsJws.getBody();

            var username = body.getSubject();
            var authorities = (List<Map<String, String>>) body.get("authorities");

            Set<SimpleGrantedAuthority> simpleGrantedAuthorities = authorities.stream()
                    .map(e -> new SimpleGrantedAuthority(e.get("authority")))
                    .collect(Collectors.toSet());


            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    username, null, simpleGrantedAuthorities
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

        } catch (JwtException e) {
            throw new IllegalStateException("Invalid token");
        }

        filterChain.doFilter(request, response);

    }



}
