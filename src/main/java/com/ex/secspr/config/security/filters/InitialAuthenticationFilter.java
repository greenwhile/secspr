package com.ex.secspr.config.security.filters;

import com.ex.secspr.config.security.authentication.UsernamePasswordAuthentication;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;


@AllArgsConstructor
//@Component
public class InitialAuthenticationFilter extends OncePerRequestFilter {


    @Qualifier("manager")
    private AuthenticationManager manager;

//    @Value("${jwt.signing.key}")
    private String signingKey;

//    public InitialAuthenticationFilter(AuthenticationManager manager, String signingKey) {
//        manager = manager;
//        signingKey = signingKey;
//    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String username = request.getHeader("username");
        String password = request.getHeader("password");
        System.out.println("From InitialAuthenticationFilter");
        System.out.println("username: " + username + " password: " + password);
        System.out.println("*********************************************");
//        String code = request.getHeader("code");

//        if (code == null) {
            Authentication a = new UsernamePasswordAuthentication(username, password);
            manager.authenticate(a);
//        } else {
//            Authentication a = new OtpAuthentication(username, code);
//            manager.authenticate(a);

            SecretKey key = Keys.hmacShaKeyFor(signingKey.getBytes(StandardCharsets.UTF_8));
            String jwt = Jwts.builder()
                    .setClaims(Map.of("username", username))
                    .signWith(key)
                    .compact();
            response.setHeader("Authorization", jwt);
            System.out.println("jwt: " +  jwt);
//        }

    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return !request.getServletPath().equals("/login");
    }
}
