package com.ex.secspr.config;

import com.ex.secspr.config.security.filters.InitialAuthenticationFilter;
import com.ex.secspr.config.security.providers.UsernamePasswordAuthenticationProvider;
import com.ex.secspr.model.User;
import com.ex.secspr.service.InMemoryUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import javax.sql.DataSource;
import org.springframework.security.provisioning.JdbcUserDetailsManager;


@Configuration
public class Config extends WebSecurityConfigurerAdapter {

//    @Value("${our.very.very.very.secret.key}")
//    private String signingKey;
//    @Bean
//    public InitialAuthenticationFilter initialAuthenticationFilter() throws Exception {
//        return new InitialAuthenticationFilter(authenticationManager(), signingKey);
//    }
//
//    @Autowired
//    private UsernamePasswordAuthenticationProvider usernamePasswordAuthenticationProvider;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) {
////        auth.authenticationProvider(otpAuthenticationProvider)
//                auth.authenticationProvider(usernamePasswordAuthenticationProvider);
//    }
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.csrf().disable();
//
////        http.addFilterAfter(
////                        initialAuthenticationFilter(),
////                        BasicAuthenticationFilter.class);
////                .addFilterAfter(
////                        jwtAuthenticationFilter,
////                        BasicAuthenticationFilter.class
////                );
//
////        http.authorizeRequests()
//////                .antMatchers("/demo")
////                .anyRequest().authenticated();
////    }
//
//    @Override
//    @Bean("manager")
//    protected AuthenticationManager authenticationManager() throws Exception {
//        return super.authenticationManager();
//    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        String usersByUsernameQuery = "select username, password, enabled from spring.users where username = ?";
        String authsByUserQuery = "select username, authority from spring.authorities where username = ?";
        var userDetailsManager = new JdbcUserDetailsManager(dataSource);
        userDetailsManager.setUsersByUsernameQuery(usersByUsernameQuery);
        userDetailsManager.setAuthoritiesByUsernameQuery(authsByUserQuery);
        return userDetailsManager;

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
