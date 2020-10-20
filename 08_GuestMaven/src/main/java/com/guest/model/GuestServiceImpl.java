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

	//삭제
	public void delete(int num) {
		dao.dao_delete(num);
	}

	//전체보기
	public List<GuestVO> list(HashMap<String, Object> hm) {
		return dao.dao_list(hm);
	}

	//상세보기
	public GuestVO findById(int num) {
		return dao.dao_findById(num);
	}

	//개수
	public int count(HashMap<String, Object> hm) {
		return dao.dao_count(hm);
	}
}