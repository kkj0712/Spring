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
	
	//추가하기
	public int dao_guestInsert(GuestBookDTO gb) {
		return mapper.insert(gb);
	}

	//전체보기
	public List<GuestBookDTO> dao_list(HashMap<String, Object> hm) {
		return mapper.list(hm);
	}

	//상세보기
	public GuestBookDTO dao_findByNum(int num) {
		return mapper.findByNum(num);
	}


	public void dao_updateGuest(GuestBookDTO gb) {
		// TODO Auto-generated method stub
		
	}

	//삭제하기
	public void dao_deleteGuest(int num) {
		mapper.delete(num);
	}

	//개수
	public int dao_countGuest(HashMap<String, Object> hm) {
		return mapper.count(hm);
	}

}
