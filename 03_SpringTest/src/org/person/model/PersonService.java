package org.person.model;

import java.util.List;

public interface PersonService {
	//추가
	public void person_insert(PersonVO person);
	//수정
	public void person_update(PersonVO person);
	//삭제
	public void person_delete(String id);
	//전체보기
	public List<PersonVO> person_list();
	//상세보기
	public PersonVO person_detail(String id);
}
