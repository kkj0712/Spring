package com.myguest.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestBookServiceImpl implements GuestBookService{
	@Autowired
	private GuestBookDAO dao;
	
	//추가하기
	public int guestInsert(GuestBookDTO gb) {
		return dao.dao_guestInsert(gb);
	}

	//전체보기
	public List<GuestBookDTO> list(HashMap<String, Object> hm) {
		return dao.dao_list(hm);
	}

	//상세보기
	public GuestBookDTO findByNum(int num) {
		return dao.dao_findByNum(num);
	}

	@Override
	public void updateGuest(GuestBookDTO gb) {
		// TODO Auto-generated method stub
		
	}

	//삭제하기
	public void deleteGuest(int num) {
		dao.dao_deleteGuest(num);
	}

	//개수
	public int countGuest(HashMap<String, Object> hm) {
		return dao.dao_countGuest(hm);
	}

}
