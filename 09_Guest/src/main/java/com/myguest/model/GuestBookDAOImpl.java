package com.myguest.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myguest.mapper.GuestBookMapper;

@Repository
public class GuestBookDAOImpl implements GuestBookDAO{
	@Autowired
	private GuestBookMapper mapper;
	
	@Override
	public int dao_guestInsert(GuestBookDTO gb) {
		// TODO Auto-generated method stub
		return 0;
	}

	//전체보기
	public List<GuestBookDTO> dao_list(HashMap<String, Object> hm) {
		return mapper.list(hm);
	}

	@Override
	public GuestBookDTO dao_findByNum(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dao_updateGuest(GuestBookDTO gb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dao_deleteGuest(int num) {
		// TODO Auto-generated method stub
		
	}

	//개수
	public int dao_countGuest(HashMap<String, Object> hm) {
		return mapper.count(hm);
	}

}
