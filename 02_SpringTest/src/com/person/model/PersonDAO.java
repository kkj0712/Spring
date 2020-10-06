package com.person.model;

import java.util.List;

public interface PersonDAO {
	//�߰�
	public void personInsert(Person p);
	//��ü����
	public List<Person> personList();
	//����
	public void personUpdate(Person p);
	//����
	public void personDelete(String id);
	//�󼼺���
	public Person personView(String id);
}