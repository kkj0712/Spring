package com.guest.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guest.vo.GuestVO;

@Service
public class GuestServiceImpl implements GuestService {
	@Autowired
	private GuestDAO dao;

	//�߰�
	public void insert(GuestVO guest) {
		dao.dao_insert(guest);
	}

	//����
	public void update(GuestVO guest) {
		
	}

	public void delete(int num) {
		
	}

	//��ü����
	public List<GuestVO> list(HashMap<String, Object> hm) {
		return dao.dao_list(hm);
	}

	public GuestVO findById(int num) {
		return null;
	}

	public int count(HashMap<String, Object> hm) {
		return 0;
	}
}