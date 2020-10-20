package com.myguest.model;

import java.util.HashMap;
import java.util.List;

public interface GuestBookService {
	//추가
	public int guestInsert(GuestBookDTO gb);
	//전체보기
	public List<GuestBookDTO> list(HashMap<String, Object> hm);
	//상세보기
	public GuestBookDTO findByNum(int num);
	//수정
	public void updateGuest(GuestBookDTO gb);
	//삭제
	public void deleteGuest(int num);
	//갯수
	public int countGuest(HashMap<String, Object> hm);
}
