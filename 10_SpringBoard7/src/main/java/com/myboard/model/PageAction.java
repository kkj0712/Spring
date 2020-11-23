package com.myboard.model;

import org.springframework.stereotype.Component;

@Component
public class PageAction {

	
	public String paging(int count, int pageSize, int currentPage, String field, String word) {
		
		String file="javascript:getData(";
		int pageCount = count/pageSize+(count%pageSize==0?0:1); //총 페이지수
		int pageBlock = 3;	//3페이씩 블럭에 담음
		int startPage = ((currentPage-1)/pageBlock)*pageBlock+1; //블럭당 시작 변수
		int endPage = startPage+pageBlock-1; //블럭당 마지막 변수
		if(endPage>pageCount) endPage=pageCount; 
		//총 게시물 10개. 한 페이지당 3개씩 보여준다. 총 페이지수는?: 4페이지
		//1, 2, 3, 4 페이지가 있을 것임. 페이지 블락이 3이므로 << 1 2 3 >> 그리고 << 4 >> 이렇게 있겠지
		//마지막 페이지
		
		StringBuilder sb = new StringBuilder();
		if(count>0) {
			//이전
			if(startPage>pageBlock) {
				sb.append("<a href=");
				sb.append(file);
				sb.append((startPage-pageBlock));
				sb.append(",'"+field);
				sb.append("','"+word+"')");
				sb.append(">이전</a>");				
			}
			
			//페이지번호
			for(int i=startPage; i<=endPage; i++) {
				if(i==currentPage) {//현재 페이지 링크 없음
					sb.append("["+i+"]");
				}else {//현재 페이지 아님 링크 걸기
					sb.append("<a href=");
					sb.append(file);
					sb.append(i);
					sb.append(",'"+field);
					sb.append("','"+word+"')");
					sb.append(">["+i+"]</a>");
				}
			}
			
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
