package com.myguest.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
public class GuestListVO {
	private int count;
	private List<GuestBookDTO> list;
	private String pageHtml;
	
	@Builder
	//이 객체를 만드는 이유?: Controller에서부터 넘겨줘야 할 값이 3개라서 (개수, 내용, 페이징). 이 객체를 한꺼번에 return 시킬려고.
	public GuestListVO(int count, List<GuestBookDTO> list, String pageHtml) {
		this.count=count;
		this.list=list;
		this.pageHtml=pageHtml;
	}
}
