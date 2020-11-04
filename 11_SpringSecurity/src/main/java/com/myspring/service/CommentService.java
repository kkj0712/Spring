package com.myspring.service;

import java.util.List;

import com.myspring.dto.CommentDTO;



public interface CommentService {
	public void insert(CommentDTO comment);
	public List<CommentDTO> getList(int bnum);
	public void delete(int cnum);
}
