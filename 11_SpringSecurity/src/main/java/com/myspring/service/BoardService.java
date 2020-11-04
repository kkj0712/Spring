package com.myspring.service;

import java.util.HashMap;
import java.util.List;

import com.myspring.dto.BoardDTO;

public interface BoardService {
	//추가
	public int insert(BoardDTO board);
	//전체보기
	public List<BoardDTO> findAll(HashMap<String, Object> hm);
	//갯수
	public int count(HashMap<String, Object> hm);
	//상세보기
	public BoardDTO findByNum(int num);
	//수정하기
	public void update(BoardDTO board);
	//삭제하기
	public void delete(int num);
}
