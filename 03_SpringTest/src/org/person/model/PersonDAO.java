package org.person.model;

import java.util.List;

public interface PersonDAO {
	//추가
	public void personInsert(PersonVO person);
	//수정
	public void personUpdate(PersonVO person);
	//삭제
	public void personDelete(String id);
	//전체보기
	public List<PersonVO> personList();
	//상세보기
	public PersonVO personDetail(String id);
}
