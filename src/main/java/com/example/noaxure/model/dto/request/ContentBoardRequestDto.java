package com.example.noaxure.model.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContentBoardRequestDto {
	private int id;
	private int contentId;
	private String contentNm;
	private int contentCategoryId;
	private int boardDetailId;
	private int boardDetailRank;
	private String boardDetailImage;
}
