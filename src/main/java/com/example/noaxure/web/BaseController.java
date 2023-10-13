package com.example.noaxure.web;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("base")
@Slf4j
public class BaseController {

    @GetMapping("/test")
    public void test(){
      log.debug("test1234");
    }
}
