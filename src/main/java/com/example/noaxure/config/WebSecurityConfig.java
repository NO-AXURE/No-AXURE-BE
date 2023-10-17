package com.example.noaxure.config;

import com.example.noaxure.auth.AuthenticationFilter;
import com.example.noaxure.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
@Slf4j
@EnableWebSecurity
public class WebSecurityConfig {


    private final UserService userService;
    private final Environment environment;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((authorize -> authorize.requestMatchers("/admin").permitAll().anyRequest().authenticated()))
                .addFilter(getAuthenticationFilter());

        httpSecurity.formLogin(form -> form.loginProcessingUrl("/user/login").usernameParameter("userId").passwordParameter("password").permitAll());

        httpSecurity.headers((headers) -> headers.frameOptions((frameOptions) -> frameOptions.disable()));


        return httpSecurity.build();
    }

    private AuthenticationFilter getAuthenticationFilter(){
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(authentication -> authentication,userService);
        return authenticationFilter;
    }
}
