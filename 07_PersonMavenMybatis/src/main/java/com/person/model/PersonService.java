package com.person.model;

import java.util.HashMap;
import java.util.List;

public interface PersonService {
	//추가
	public void insert(Person person);
	//전체
	public List<Person> list(HashMap<String, String> hm);
	//상세
	public Person detail(String id);
	//수정
	public void update(Person person);
	//삭제
	public void delete(String id);
	//인원수
	public int count();
}
