package com.example.noaxure.service.impl;

import org.springframework.stereotype.Service;

import com.example.noaxure.mapper.BoardDetailMapper;
import com.example.noaxure.model.dto.request.BoardDetailRequestDto;
import com.example.noaxure.model.table.BoardDetail;
import com.example.noaxure.service.BoardDetailService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardDetailServiceImpl implements BoardDetailService{
	private final BoardDetailMapper boardDetailMapper;

	@Override
	public BoardDetail get(int id) {
		return boardDetailMapper.selectBoardDetail(id);
	}

	@Override
	public int update(BoardDetailRequestDto boardDetailRequestDto) {
		return boardDetailMapper.updateBoardDetail(boardDetailRequestDto.toModel());
	}

	@Override
	public BoardDetail getContentBoardfileData(int id) {
		// TODO Auto-generated method stub
		return boardDetailMapper.selectContentBoardfileDataById(id);
	}

}
