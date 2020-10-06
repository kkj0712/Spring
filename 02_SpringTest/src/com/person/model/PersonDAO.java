package com.person.model;

import java.util.List;

public interface PersonDAO {
	//추가
	public void personInsert(Person p);
	//전체보기
	public List<Person> personList();
	//수정
	public void personUpdate(Person p);
	//삭제
	public void personDelete(String id);
	//상세보기
	public Person personView(String id);
}