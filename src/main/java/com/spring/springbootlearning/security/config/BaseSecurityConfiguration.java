package com.spring.springbootlearning.security.config;

import com.spring.springbootlearning.service.UserDetailsServiceCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class BaseSecurityConfiguration {
    private UserDetailsServiceCustom userDetailsServiceCustom;
    @Autowired
    public BaseSecurityConfiguration(UserDetailsServiceCustom userDetailsServiceCustom) {
        this.userDetailsServiceCustom = userDetailsServiceCustom;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll()
                .anyRequest().authenticated()
                .and().logout().logoutUrl("/logout")
                .and()
                .httpBasic();
        return httpSecurity.build();
    }

    @Bean
    public AuthenticationManager authenticationManager (AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}