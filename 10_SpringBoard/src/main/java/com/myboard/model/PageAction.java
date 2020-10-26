package com.myboard.model;

import org.springframework.stereotype.Component;

@Component
public class PageAction {
	public String paging(int count, int pageSize, int currentPage, String field, String word) {
		String file="javascript:getData(";
		int pageCount=count/pageSize+(count%pageSize==0?0:1); //전체 페이지 수=게시글 수/나눌 페이지 수
		int pageBlock=3; //123 /456 이런식으로 밑에 보여줄 페이지 수
		int startPage=((currentPage-1)/pageBlock)*pageBlock+1; //시작 페이지
		int endPage=startPage+pageBlock-1; //마지막 페이지
		if(endPage>pageCount) endPage=pageCount;
		StringBuilder sb=new StringBuilder();
		if(count>0) {
			//이전
			if(startPage>pageBlock) { //getData(1,'name', '홍길동');
				sb.append("<a href=");
				sb.append(file);
				sb.append((startPage-pageBlock));
				sb.append(",'"+field);
				sb.append("','"+word+"')");
				sb.append(">이전</a>");
			}
			//페이지 번호
			for(int i=startPage;i<=endPage;i++) {
				if(i==currentPage) {
					sb.append("["+i+"]");
				}else {
					sb.append("<a href=");
					sb.append(file);
					sb.append(i);
					sb.append(",'"+field);
					sb.append("','"+word+"')");
					sb.append(">["+i+"]</a>");
				}
			}
			//다음
			//다음
			if(endPage<pageCount) {
				sb.append("<a href=");
				sb.append(file);
				sb.append((startPage+pageBlock));
				sb.append(",'"+field);
				sb.append("','"+word+"')");
				sb.append(">다음</a>");
			}
		}
		return sb.toString();
	}
}
