package com.students.lms.config;

import com.students.lms.statics.Statics;
import com.students.lms.security.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;
//import org.thymeleaf.spring5.SpringTemplateEngine;

@Configuration
@EnableWebSecurity
public class SpringSecurity {
    @Autowired
    private UserDetailsService userDetailsService;


    @Bean
    public static PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()  // Disable CSRF protection
                .authorizeRequests()  // Enable request authorization
                .requestMatchers("/register/**").permitAll()// Allow all requests to /register/**
//                .requestMatchers("/books/**").permitAll()// Allow all requests to /register/**
                .requestMatchers("/index/**").permitAll()  // Allow all requests to /index/**
                .requestMatchers("/usersdsadsad").hasRole(Statics.PRIVILEGED_USER)  // Restrict /users to users with ADMIN role
                .anyRequest().authenticated()  // All other requests need to be authenticated
                .and()
                .formLogin()  // Enable form login
                .loginPage("/login")  // Custom login page
                .loginProcessingUrl("/login")  // URL to submit the username and password
                .defaultSuccessUrl("/books", true)  // Default URL after successful login
                .permitAll()  // Allow everyone to see the login page
                .and()
                .logout()  // Enable logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))  // Custom logout URL
                .permitAll();  // Allow everyone to access logout URL

        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder());
    }


}