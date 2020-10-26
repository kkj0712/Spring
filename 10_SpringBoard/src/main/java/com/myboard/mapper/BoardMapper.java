package com.myboard.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;

import com.myboard.dto.BoardDTO;

public interface BoardMapper {
	@Insert("insert into springboard values(springboard_seq.nextval, #{title}, #{content}, #{writer}, sysdate, 0, #{password})")
	//추가
	public int insert(BoardDTO board);
	//전체보기
	public List<BoardDTO> findAll(HashMap<String, Object> hm);
	//상세보기
	public BoardDTO findByNum(int num);
	//수정
	public void update(BoardDTO board);
	//삭제
	public void delete(int num);
	//개수
	public int count(HashMap<String, Object> hm);
	//조회수
	public void updateHitCount(int num);
}
