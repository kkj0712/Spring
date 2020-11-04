package com.myspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.dto.CommentDTO;
import com.myspring.mapper.BoardMapper;
import com.myspring.mapper.CommentMapper;


@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentMapper cmapper;
	
	@Autowired
	private BoardMapper bmapper;

	@Override
	public List<CommentDTO> getList(int num) {
		return cmapper.getList(num);
	}

	@Transactional
	@Override
	public void insert(CommentDTO comment) {
		System.out.println(comment.getBnum());
		bmapper.updateReplyCnt(comment.getBnum(),1);
		cmapper.insert(comment);
	}
	
	@Transactional
	@Override
	public void delete(int cnum) {		
		CommentDTO cdto = cmapper.read(cnum);
		bmapper.updateReplyCnt(cdto.getBnum(),-1);
		cmapper.delete(cnum);
	}
}
