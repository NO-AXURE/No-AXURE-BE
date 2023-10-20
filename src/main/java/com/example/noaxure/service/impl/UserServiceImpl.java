package com.example.noaxure.service.impl;


import com.example.noaxure.mapper.UserMapper;
import com.example.noaxure.model.dto.request.UserRequestDto;
import com.example.noaxure.model.table.User;
import com.example.noaxure.security.LoginUser;
import com.example.noaxure.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;
    @Override
    public User get(String userId) {
        return userMapper.selectUser(userId);
    }

    @Override
    public int add(UserRequestDto userRequestDto) {
        return userMapper.insertUser(userRequestDto.toModel());
    }

    @Override
    public int update(UserRequestDto userRequestDto) {
        return userMapper.updateUser(userRequestDto.toModel());
    }

    @Override
    public int signUp(UserRequestDto userRequestDto) {
        userRequestDto.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        return userMapper.insertUser(userRequestDto.toModel());
    }

    @Override
    public int delete(UserRequestDto userRequestDto) {
        return userMapper.deleteUser(userRequestDto.toModel());
    }



}
