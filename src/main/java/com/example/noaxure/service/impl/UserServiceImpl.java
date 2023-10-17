package com.example.noaxure.service.impl;


import com.example.noaxure.mapper.UserMapper;
import com.example.noaxure.model.dto.request.UserRequestDto;
import com.example.noaxure.model.table.User;
import com.example.noaxure.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
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
    public int delete(UserRequestDto userRequestDto) {
        return userMapper.deleteUser(userRequestDto.toModel());
    }


}
