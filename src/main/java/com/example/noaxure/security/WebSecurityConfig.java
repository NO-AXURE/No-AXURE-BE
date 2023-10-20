package com.example.noaxure.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class WebSecurityConfig {

    private final jwtSupport jwtSupport;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf((csrf) -> csrf.disable());


        httpSecurity.securityMatcher("/login")
                 .authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
                .addFilterBefore(new LoginFilter(jwtSupport), UsernamePasswordAuthenticationFilter.class);

        httpSecurity.formLogin(form -> form.loginPage("/login").permitAll());


        httpSecurity.headers((headers) -> headers.frameOptions((frameOptions) -> frameOptions.disable()));



        return httpSecurity.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }



}
