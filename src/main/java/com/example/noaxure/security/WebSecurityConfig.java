package com.example.noaxure.security;

import com.example.noaxure.service.UserService;
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
@EnableWebSecurity
public class WebSecurityConfig {

    private final jwtSupport jwtSupport;
    private final UserService userService;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf((csrf) -> csrf.disable());

        httpSecurity
                .authorizeHttpRequests((authorize -> authorize.requestMatchers("/login").permitAll()
                        .requestMatchers("/**").permitAll()))//authenticated 차후변경
                .addFilterBefore(new LoginFilter(jwtSupport), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new AuthenticationFilter(jwtSupport,userService), UsernamePasswordAuthenticationFilter.class);




        httpSecurity.formLogin(form -> form.loginPage("/login").permitAll());


        httpSecurity.headers((headers) -> headers.frameOptions((frameOptions) -> frameOptions.disable()));



        return httpSecurity.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }



}
