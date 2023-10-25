package com.example.noaxure.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.noaxure.model.dto.request.ContentBoardRequestDto;
import com.example.noaxure.model.dto.response.ResultData;
import com.example.noaxure.service.ContentBoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("contentboard")
@Slf4j
@RequiredArgsConstructor
public class ContentBoardController {
	private final ContentBoardService contentBoardSerive;

	@GetMapping("/contentboardmain")
	public ResponseEntity<ResultData> getcontentBoardMainData(){
		List<ContentBoardRequestDto> dataList = contentBoardSerive.getContentBoardRequestDtoList();

		return ResultData.ok(dataList);
	}
}
