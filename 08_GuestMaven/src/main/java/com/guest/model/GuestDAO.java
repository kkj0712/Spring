package com.guest.model;

import java.util.HashMap;
import java.util.List;


import com.guest.vo.GuestVO;

public interface GuestDAO {
	//추가
	public void dao_insert(GuestVO guest);
	//수정
	public void dao_update(GuestVO guest);
	//삭제
	public void dao_delete(int num);
	//전체보기(검색포함)
	public List<GuestVO> dao_list(HashMap<String, Object>hm);
	//상세보기
	public GuestVO dao_findById(int num);
	
	public int dao_count(HashMap<String, Object>hm);
}
