package com.example.noaxure.web;


import com.example.noaxure.model.dto.request.UserRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @PostMapping("/login")
    public ResponseEntity<?> login(UserRequestDto dto){
        return ResponseEntity.ok(dto);
    }
}
