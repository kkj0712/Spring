package com.myspring.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.myspring.dto.BoardDTO;

public interface BoardMapper {
	@Insert("insert into springboard(num, title, content, writer, regdate, hitcount, password) "
			+ "values (springboard_seq.nextval, #{title}, #{content}, #{writer}, sysdate, 1, #{password})")
	public int insert(BoardDTO board);
	
	public List<BoardDTO> findAll(HashMap<String, Object> hm);
	
	public int count(HashMap<String, Object> hm);
	
	@Select("select * from springboard where num=#{num}")
	public BoardDTO findByNum(int num);
	
	@Update("update springboard "
			+ "set title=#{title}, content=#{content}, writer=#{writer}, password=#{password} "
			+ "where num=#{num}")
	public void update(BoardDTO board);
	
	@Delete("delete from springboard where num=#{num}")
	public void delete(int num);
	
	public void updateReplyCnt(@Param("bnum")int bnum, @Param("amount") int amount);
}
