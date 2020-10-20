package com.myguest.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestBookServiceImpl implements GuestBookService{
	@Autowired
	private GuestBookDAO dao;
	
	@Override
	public int guestInsert(GuestBookDTO gb) {
		// TODO Auto-generated method stub
		return 0;
	}

	//전체보기
	public List<GuestBookDTO> list(HashMap<String, Object> hm) {
		return dao.dao_list(hm);
	}

	@Override
	public GuestBookDTO findByNum(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateGuest(GuestBookDTO gb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGuest(int num) {
		// TODO Auto-generated method stub
		
	}

	//개수
	public int countGuest(HashMap<String, Object> hm) {
		return dao.dao_countGuest(hm);
	}

}
