package com.myboard.model;

import java.util.List;

import com.myboard.dto.CommentDTO;

public interface CommentService {
	//추가
	public void insert(CommentDTO comment);
	//상세보기
	public List<CommentDTO> getList(int bnum);
	//수정
	//삭제
	//리스트

	public void delete(int cnum);
}
