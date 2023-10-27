package com.example.noaxure.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.noaxure.model.dto.request.BoardDetailRequestDto;
import com.example.noaxure.model.dto.response.ResultData;
import com.example.noaxure.model.table.BoardDetail;
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
//	public ResponseEntity<ResultData> getimage(@PathVariable int id){
//		BoardDetail dto = boardDetailService.get(id);
//		return ResultData.ok(dto);
//	}


//	이미지 업로드용 안쓸꺼임 이제
//	@PutMapping("/imageUpdate")
//    public ResponseEntity<ResultData> imageUpdate(@RequestBody byte[] imageContent){
//		BoardDetailRequestDto dto = new BoardDetailRequestDto();
//		dto.setId(8);
//		dto.setImage(imageContent);
//		System.out.println(dto.getImage().length);
//		int result = boardDetailService.update(dto);
//
//		return ResultData.ok(result);
//	}
//
}
