package com.example.noaxure.web;


import com.example.noaxure.model.dto.request.UserRequestDto;
import com.example.noaxure.model.dto.response.ResultData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @PostMapping("/login")
    public ResponseEntity<ResultData> login(UserRequestDto dto){
        return ResultData.ok(dto);
    }

    @PostMapping("/signUp")
    public ResponseEntity<ResultData> signUp(UserRequestDto dto){
        return ResultData.ok(dto);
    }
}
