package com.example.demo5.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="tbl_user")
public class User {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long user_id;
	private String username;
	private String nick_name;
	private String address;
	
	//한 사람이 주문을 여러번 할 수 있음
	@OneToMany(mappedBy="user") //user를 참조한다. 1:N 관계지만 다대다 양상이 나타남. Order가 주인 테이블이 되어 FK인 user_id를 참고로 조회.
	private List<Order> orders;
}