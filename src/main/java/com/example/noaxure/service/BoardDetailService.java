package com.example.noaxure.service;


import org.springframework.transaction.annotation.Transactional;

import com.example.noaxure.model.dto.request.BoardDetailRequestDto;

@Transactional
public interface BoardDetailService  {

    public int update(BoardDetailRequestDto boardDetailRequestDto);



}
