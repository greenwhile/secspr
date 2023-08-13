//package com.ex.secspr.config;
//
//import com.ex.secspr.config.security.filters.CustomAuthenticationFilter;
//import com.ex.secspr.config.security.filters.InitialAuthenticationFilter;
//import com.ex.secspr.config.security.providers.UsernamePasswordAuthenticationProvider;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.context.annotation.Primary;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@AllArgsConstructor
//public class SecurityConfig {
//
////    private final CustomAuthenticationFilter customAuthenticationFilter;
//
//    private UsernamePasswordAuthenticationProvider usernamePasswordAuthenticationProvider;
//
//    public void configure(AuthenticationManagerBuilder auth) {
//        auth.authenticationProvider(usernamePasswordAuthenticationProvider);
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
////                .addFilterAt(customAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
//
//                .authorizeRequests().anyRequest().authenticated()  // don't worry about this
//                .and().build();
//    }
//
//
//    @Bean
//    public UserDetailsService userDetailsService(){
//        var manager = new InMemoryUserDetailsManager();
//        var u = User.withUsername("john")
//                .password("12345")
//                .authorities("admin")
//                .build();
//
//        manager.createUser(u);
//        return manager;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }
//}
