package com.guest.model;

import java.util.HashMap;
import java.util.List;

import com.guest.vo.GuestVO;

public interface GuestService {
	//추가
	public void insert(GuestVO guest);
	//수정
	public void update(GuestVO guest);
	//삭제
	public void delete(int num);
	//전체보기(검색포함)
	public List<GuestVO> list(HashMap<String, Object>hm);
	//상세보기
	public GuestVO findById(int num);
	
	public int count(HashMap<String, Object>hm);
}
