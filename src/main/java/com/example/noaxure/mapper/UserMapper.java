package com.example.noaxure.mapper;


import com.example.noaxure.model.dto.request.UserRequestDto;
import com.example.noaxure.model.table.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User selectUser(String userId);
    int insertUser(User user);
    int updateUser(User user);
    int deleteUser(User user);
}
