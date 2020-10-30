package com.myboard.dto;

import lombok.Data;

@Data
public class CommentDTO {
	private int cnum;
	private String userid;
	private String content;
	private String regdate;
	private int bnum;
}
