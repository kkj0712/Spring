package com.example.demo5.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="tbl_order")
public class Order {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long order_id;
	private String order_name;
	private String note;
	private int price;
	
	//1:다 관계
	//지연전략. 조인을 할때 조인된 유저의 값을 바로 조인시켜서 알려줄건지, 실행할때 user 객체를 select해서 보여줄건지
	@ManyToOne(fetch=FetchType.LAZY) 
	//주문자의 정보. 외래키.
	@JoinColumn(name="user_id")
	private User user;
}
