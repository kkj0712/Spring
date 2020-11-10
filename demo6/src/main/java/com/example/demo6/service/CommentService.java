package com.example.demo6.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo6.dto.CommentDTO;
import com.example.demo6.model.StarterComment;
import com.example.demo6.repository.CommentRepository;
import com.example.demo6.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
	
	private final CommentRepository commentRepository;
	
	@Transactional
	public List<StarterComment> getcomList(Long bnum){
		return commentRepository.findByBnum(bnum);
	}
	
	@Transactional
	public void com_Insert(CommentDTO comment) {
		commentRepository.commentInsert(comment.getBnum(), comment.getContent());
	}
}
