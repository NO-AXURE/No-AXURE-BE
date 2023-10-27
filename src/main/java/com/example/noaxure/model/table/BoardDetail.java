package com.example.noaxure.model.table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BoardDetail{
    private int id;
    private String title;
    private String content;
    private byte[] image;
    private int rank;
    private int contentBoardId;

    @Builder
    public BoardDetail(int id, String title, String content, byte[] image,int rank, int contentBoardId) {
    	this.id = id;
    	this.title = title;
    	this.content = content;
    	this.image = image;
    	this.rank = rank;
    	this.contentBoardId = contentBoardId;
    }
}
