package com.myguest.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestBookServiceImpl implements GuestBookService{
	@Autowired
	private GuestBookDAO dao;
	
	//�߰��ϱ�
	public int guestInsert(GuestBookDTO gb) {
		return dao.dao_guestInsert(gb);
	}

	//��ü����
	public List<GuestBookDTO> list(HashMap<String, Object> hm) {
		return dao.dao_list(hm);
	}

	//�󼼺���
	public GuestBookDTO findByNum(int num) {
		return dao.dao_findByNum(num);
	}

	@Override
	public void updateGuest(GuestBookDTO gb) {
		// TODO Auto-generated method stub
		
	}

	//�����ϱ�
	public void deleteGuest(int num) {
		dao.dao_deleteGuest(num);
	}

	//����
	public int countGuest(HashMap<String, Object> hm) {
		return dao.dao_countGuest(hm);
	}

}
