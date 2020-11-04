package com.myspring.service;

import java.util.HashMap;
import java.util.List;

import com.myspring.dto.BoardDTO;

public interface BoardService {
	//�߰�
	public int insert(BoardDTO board);
	//��ü����
	public List<BoardDTO> findAll(HashMap<String, Object> hm);
	//����
	public int count(HashMap<String, Object> hm);
	//�󼼺���
	public BoardDTO findByNum(int num);
	//�����ϱ�
	public void update(BoardDTO board);
	//�����ϱ�
	public void delete(int num);
}
