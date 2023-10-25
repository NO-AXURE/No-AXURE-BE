package com.example.noaxure.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.example.noaxure.model.dto.request.ContentBoardRequestDto;

@Transactional
public interface ContentBoardService {
	public List<ContentBoardRequestDto> getContentBoardRequestDtoList();
}
