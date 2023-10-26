package com.example.noaxure.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.noaxure.model.dto.request.BoardDetailRequestDto;
import com.example.noaxure.model.dto.response.ResultData;
import com.example.noaxure.service.BoardDetailService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("boarddetail")
@Slf4j
@RequiredArgsConstructor
public class BoardDetailController {
	private final BoardDetailService boardDetailService;

//	@GetMapping("/{id}")
//	public ResponseEntity<ResultData> get(@PathVariable int id){
//
//		return null;
//	}

	@PutMapping("/")
    public ResponseEntity<ResultData> post(@RequestBody BoardDetailRequestDto dto){
		System.out.println("123");
		int result = boardDetailService.update(dto);

		return ResultData.ok(result);
	}
}
