package com.example.noaxure.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.noaxure.mapper.ContentBoardMapper;
import com.example.noaxure.model.dto.request.ContentBoardRequestDto;
import com.example.noaxure.service.ContentBoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContentBoardServiceImpl implements ContentBoardService{
	private final ContentBoardMapper contentBoardMapper;

	@Override
	public List<ContentBoardRequestDto> getContentBoardRequestDtoList() {

		return contentBoardMapper.selectContentBoardDataList();
	}

}
