package com.myboard.model;

import java.util.List;

import com.myboard.dto.BoardDTO;

import lombok.Builder;
import lombok.Data;

@Data
public class BoardListDTO {
	private int count;
	private List<BoardDTO> list;
	private String pageHtml;
	
	@Builder
	public BoardListDTO(int count, List<BoardDTO> list, String pageHtml) {
		this.count=count;
		this.list=list;
		this.pageHtml=pageHtml;
	}
}
