package com.myboard.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myboard.dto.CommentDTO;
import com.myboard.mapper.BoardMapper;
import com.myboard.mapper.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentMapper cmapper;
	
	@Autowired
	private BoardMapper bmapper;

	@Override
	public List<CommentDTO> getList(int num) {
		// TODO Auto-generated method stub
		return cmapper.getList(num);
	}

	@Transactional //두개의 작업을 하나로 묶어서 처리
	@Override
	public void insert(CommentDTO comment) {
		bmapper.updateReplyCnt(comment.getBnum(),1); //댓글수 증가될때마다 replycnt 값 1증가
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
