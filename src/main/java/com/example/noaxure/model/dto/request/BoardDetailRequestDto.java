package com.example.noaxure.model.dto.request;


import org.springframework.security.core.userdetails.User;

import com.example.noaxure.model.table.BoardDetail;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BoardDetailRequestDto {

	private int id;
    private String title;
    private String content;
    private byte[] image;
    private int rank;
    private int contentBoardId;

    public BoardDetail toModel() {
    	return BoardDetail.builder()
    			.id(this.id)
    			.title(this.title)
    			.content(this.content)
    			.image(this.image)
    			.rank(this.rank)
    			.contentBoardId(this.contentBoardId)
    			.build();
    }
}
