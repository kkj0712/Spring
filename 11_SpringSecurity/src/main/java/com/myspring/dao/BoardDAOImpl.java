package com.myspring.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myspring.dto.BoardDTO;
import com.myspring.mapper.BoardMapper;

@Repository
public class BoardDAOImpl implements BoardDAO{
	@Autowired
	private BoardMapper bmapper;
	
	@Override
	public int dao_insert(BoardDTO board) {
		return bmapper.insert(board);
	}

	@Override
	public int dao_count(HashMap<String, Object> hm) {
		return bmapper.count(hm);
	}

	@Override
	public List<BoardDTO> dao_findAll(HashMap<String, Object> hm) {
		return bmapper.findAll(hm);
	}

	@Override
	public BoardDTO dao_findByNum(int num) {
		return bmapper.findByNum(num);
	}

	@Override
	public void dao_update(BoardDTO board) {
		bmapper.update(board);
	}

	@Override
	public void dao_delete(int num) {
		bmapper.delete(num);
	}
}