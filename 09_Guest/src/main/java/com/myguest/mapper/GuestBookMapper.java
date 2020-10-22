package com.myguest.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;

import com.myguest.model.GuestBookDTO;

public interface GuestBookMapper {
	@Insert("insert into guestbook values(guestbook_seq.nextval,#{name}, #{content}, #{grade}, sysdate, #{ipaddr})")
	//추가
	public int insert(GuestBookDTO gb);
	//전체보기
	public List<GuestBookDTO> list(HashMap<String, Object> hm);
	//수정
	public void update(GuestBookDTO gb);
	//삭제
	public void delete(int num);
	//상세보기
	public GuestBookDTO findByNum(int num);
	//갯수
	public int count(HashMap<String, Object> hm);
}
