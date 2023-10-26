package com.example.noaxure.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.example.noaxure.model.table.BoardDetail;

@Mapper
public interface BoardDetailMapper {
    int updateBoardDetail(BoardDetail boardDetail);
}
