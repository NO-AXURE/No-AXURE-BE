package com.example.noaxure.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.noaxure.model.dto.request.ContentBoardRequestDto;

@Mapper
public interface ContentBoardMapper {
	public List<ContentBoardRequestDto> selectContentBoardDataList();
}
