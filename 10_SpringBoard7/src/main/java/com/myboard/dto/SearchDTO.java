package com.myboard.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchDTO {
	private int pageNum=1;
	private int amount=10;
	private String field;
	private String word;
	

}
