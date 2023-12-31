package com.example.noaxure.service;


import com.example.noaxure.model.dto.request.UserRequestDto;

import com.example.noaxure.model.table.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService  {

    public User get(String userId);

    public int add(UserRequestDto userRequestDto);

    public int delete(UserRequestDto userRequestDto);

    public int update(UserRequestDto userRequestDto);

    public int signUp(UserRequestDto userRequestDto);



}
