package com.example.noaxure.model.table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class User{
    private Long id;
    private String userId;
    private String password;
    private String name;
    private String email;

    @Builder
    public User(Long id, String userId, String password, String name, String email){
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.email = email;
    }
}
