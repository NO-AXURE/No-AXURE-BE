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


    @GetMapping("/{userId}/{password}")
    public ResponseEntity<ResultData> get(@PathVariable String userId, @PathVariable String password){
        System.out.println(123);
        User user = userService.get(userId);
        user = userService.get(password);
        return ResultData.ok(user);
    }

    @PostMapping("/")
    public ResponseEntity<ResultData> post(@RequestBody UserRequestDto userRequestDto){
        int result = userService.add(userRequestDto);
        return ResultData.ok(result);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<ResultData> put(@PathVariable String userId, @RequestBody UserRequestDto userRequestDto){
        int result = userService.update(userRequestDto);
        return ResultData.ok(result);
    }

    @DeleteMapping("/{userId}/{password}")
    public ResponseEntity<ResultData> delete(@PathVariable String userId, @PathVariable String password, @RequestBody UserRequestDto userRequestDto){
        int result = userService.delete(userRequestDto);
        return ResultData.ok(result);
    }


}
