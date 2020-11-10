package com.example.demo6.service;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo6.model.StarterBoard;
import com.example.demo6.repository.BoardRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	
	private final BoardRepository boardRepository;
	
	@Transactional
	public void boardSave(StarterBoard board) {
		boardRepository.save(board);
	}
	
	@Transactional
	public Page<StarterBoard> bList(Pageable pageable){
		return boardRepository.findAll(pageable);
	}

	@Transactional
	public StarterBoard bView(Long num) {
		return boardRepository.findById(num)
				.orElseThrow(()->{
					return new IllegalArgumentException("게시글 보기 실패");
				});
	}
	
	@Transactional
	public void bUpdate(StarterBoard board) {
		StarterBoard sb=boardRepository.findById(board.getNum())
				.orElseThrow(()->{
					return new IllegalArgumentException("글수정 실패");
				});
		sb.setContent(board.getContent());
		sb.setPassword(board.getPassword());
		sb.setTitle(board.getTitle());
	}
	
	@Transactional
	public void delete(Long num) {
		boardRepository.deleteById(num);
	}
}
