package com.example.noaxure.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.example.noaxure.model.table.BoardDetail;

@Mapper
public interface BoardDetailMapper {
	BoardDetail selectBoardDetail(int id);
    int updateBoardDetail(BoardDetail boardDetail);
    BoardDetail selectContentBoardfileDataById(int id);
}
