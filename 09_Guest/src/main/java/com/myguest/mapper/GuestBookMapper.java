package com.myguest.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;

import com.myguest.model.GuestBookDTO;

public interface GuestBookMapper {
	@Insert("insert into guestbook values(guestbook_seq.nextval,#{name}, #{content}, #{grade}, sysdate, #{ipaddr})")
	//�߰�
	public int insert(GuestBookDTO gb);
	//��ü����
	public List<GuestBookDTO> list(HashMap<String, Object> hm);
	//����
	public void update(GuestBookDTO gb);
	//����
	public void delete(int num);
	//�󼼺���
	public GuestBookDTO findByNum(int num);
	//����
	public int count(HashMap<String, Object> hm);
}
