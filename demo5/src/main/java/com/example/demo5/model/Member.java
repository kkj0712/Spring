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
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	
	@Column(name="address")
	private String addr;
}
