package com.example.noaxure.web;


import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class BaseController {
	@GetMapping("/test")
	public Map<String,Object> getData(){
		Map<String,Object> map = new HashMap<>();
		map.put("테스트", "1");
		return map;
	}

}
