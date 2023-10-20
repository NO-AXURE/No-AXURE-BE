package com.example.noaxure.web;


import com.example.noaxure.model.dto.request.UserRequestDto;
import com.example.noaxure.model.dto.response.ResultData;
import com.example.noaxure.model.table.User;
import com.example.noaxure.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/{userId}")
    public ResponseEntity<ResultData> get(@PathVariable String userId){
        System.out.println(123);
        User user = userService.get(userId);
        return ResultData.ok(user);
    }

    @PostMapping("/")
    public ResponseEntity<ResultData> post(@RequestBody UserRequestDto userRequestDto){
        int result = userService.add(userRequestDto);
        return ResultData.ok(result);
    }

    @PutMapping("/")
    public ResponseEntity<ResultData> put(@RequestBody UserRequestDto userRequestDto){
        int result = userService.update(userRequestDto);
        return ResultData.ok(result);
    }

    @DeleteMapping("/")
    public ResponseEntity<ResultData> delete(@RequestBody UserRequestDto userRequestDto){
        int result = userService.delete(userRequestDto);
        return ResultData.ok(result);
    }


}
