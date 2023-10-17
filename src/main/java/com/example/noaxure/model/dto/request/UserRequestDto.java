package com.example.noaxure.model.dto.request;


import com.example.noaxure.model.table.User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserRequestDto {

    public String userId;
    public String password;
    public String name;
    public String email;

    public User toModel(){
        return User.builder()
                .userId(this.userId)
                .password(this.password)
                .name(this.name)
                .email(this.email)
                .build();
    }

}
