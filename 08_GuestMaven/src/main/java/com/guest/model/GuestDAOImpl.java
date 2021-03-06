package com.guest.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.guest.mapper.GuestMapper;
import com.guest.vo.GuestVO;

@Repository
public class GuestDAOImpl implements GuestDAO{
	@Autowired
	private GuestMapper mapper;
	
	//추가
	public void dao_insert(GuestVO guest) {
		mapper.insert(guest);
	}

	public void dao_update(GuestVO guest) {
		
	}

	//삭제
	public void dao_delete(int num) {
		mapper.delete(num);
	}

	//전체보기
	public List<GuestVO> dao_list(HashMap<String, Object> hm) {
		return mapper.list(hm);
	}

	//상세보기
	public GuestVO dao_findById(int num) {
		return mapper.view(num);
	}
	
	//갯수
	public int dao_count(HashMap<String, Object> hm) {
		return mapper.count(hm);
	}

}
