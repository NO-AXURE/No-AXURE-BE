package com.example.noaxure.web;


import com.example.noaxure.model.dto.request.UserRequestDto;
import com.example.noaxure.model.table.User;
import com.example.noaxure.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/test")
    public void test(){
        System.out.println("test");
    }
    @GetMapping("/{userId}")
    public ResponseEntity<?> get(@PathVariable String userId){
        System.out.println(123);
        User user = userService.get(userId);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/")
    public ResponseEntity<?> post(@RequestBody UserRequestDto userRequestDto){
        int result = userService.add(userRequestDto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/")
    public ResponseEntity<?> put(@RequestBody UserRequestDto userRequestDto){
        int result = userService.update(userRequestDto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/")
    public ResponseEntity<?> delete(@RequestBody UserRequestDto userRequestDto){
        int result = userService.delete(userRequestDto);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(UserRequestDto userRequestDto){
        return ResponseEntity.ok(userRequestDto);
    }
}
