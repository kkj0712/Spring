package com.member.model;

import lombok.Data;

@Data
public class Member {
	private String id;
	private String pass;
	private String name;
	private String addr;
	private String memo;
	private String reg_date;
	
}