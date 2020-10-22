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
	//�� ��ü�� ����� ����?: Controller�������� �Ѱ���� �� ���� 3���� (����, ����, ����¡). �� ��ü�� �Ѳ����� return ��ų����.
	public GuestListVO(int count, List<GuestBookDTO> list, String pageHtml) {
		this.count=count;
		this.list=list;
		this.pageHtml=pageHtml;
	}
}
