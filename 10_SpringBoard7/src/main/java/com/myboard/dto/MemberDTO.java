package com.myboard.dto;

import lombok.Data;

@Data
public class MemberDTO {

	private String id;
	private String pass;
	private String name;
	private String addr;
	private String memo;
	private String reg_date;
}
