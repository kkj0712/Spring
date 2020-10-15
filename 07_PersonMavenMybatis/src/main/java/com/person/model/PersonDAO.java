package com.person.model;

import java.util.HashMap;
import java.util.List;

public interface PersonDAO {
	//추가
	public void dao_insert(String sql_Id, Person person);
	//전체
	public List<Person> dao_list(String sql_Id, HashMap<String, String> hm);
	//상세
	public Person dao_detail(String sql_Id, String id);
	//수정
	public void dao_update(String sql_Id, Person person);
	//삭제
	public void dao_delete(String sql_Id, String id);
	
	//인원수
	public int dao_count(String sql_Id);
}
