package com.guest.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guest.vo.GuestVO;

@Service
public class GuestServiceImpl implements GuestService {
	@Autowired
	private GuestDAO dao;

	//추가
	public void insert(GuestVO guest) {
		dao.dao_insert(guest);
	}

	//수정
	public void update(GuestVO guest) {
		
	}

	public void delete(int num) {
		
	}

	//전체보기
	public List<GuestVO> list(HashMap<String, Object> hm) {
		return dao.dao_list(hm);
	}

	public GuestVO findById(int num) {
		return null;
	}

	public int count(HashMap<String, Object> hm) {
		return 0;
	}
}