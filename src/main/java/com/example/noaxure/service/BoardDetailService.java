package com.example.noaxure.service;


import org.springframework.transaction.annotation.Transactional;

import com.example.noaxure.model.dto.request.BoardDetailRequestDto;
import com.example.noaxure.model.table.BoardDetail;

@Transactional
public interface BoardDetailService  {
	public BoardDetail get(int id);
    public int update(BoardDetailRequestDto boardDetailRequestDto);
	public BoardDetail getContentBoardfileData(int id);
}
