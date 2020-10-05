package com.person.model;

import java.util.List;

public interface PersonDAO {
	//�߰�
	public void personInsert(PersonDTO person);
	//��ü����
	public List<PersonDTO> findAll();
	//�����ϱ�
	public void personUpdate(String id);
	//�����ϱ�
	public void personDelete(String id);
	//�󼼺���
	public PersonDTO findById(String id);
}