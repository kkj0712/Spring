package com.example.demo1.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor //디폴트 생성자 만들어주는 어노테이션
@NoArgsConstructor //인자가 없는 생성자 만들어주는 어노테이션
public class DeptVO {
	@JsonProperty //json 형태로 return 시켜달라는 뜻
	private int deptno;
	@JsonProperty
	private String dname;
	@JsonProperty
	private String loc;
}
