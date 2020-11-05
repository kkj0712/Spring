package com.example.demo5.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Member {
	//@Id:PK 지정
	//@GeneratedValue: PK값을 위한 자동 생성 전략. auto외에도 identity, sequence, table이 있음
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String password;
	private String email;
	private String memo;
	
	
	//@Column: 테이블의 컬럼명 매핑. 지정 안하는 경우 객체 필드명과 동일하게 지정
	@Column(name="address")
	private String addr;
}
