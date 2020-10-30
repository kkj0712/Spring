package com.myboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;

import com.myboard.dto.CommentDTO;

public interface CommentMapper {
	
	public List<CommentDTO> getList(int bnum);
	
	public void insert(CommentDTO comment);
	
	@Delete("delete from commentspringboard where cnum=#{cnum}")
	public void delete(int cnum);
	
	//read
	public CommentDTO read(int cnum);

}
