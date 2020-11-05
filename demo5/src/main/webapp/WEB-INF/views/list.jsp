<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container"><br/>
<h3>회원목록</h3>
<table class="table table-striped">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>이메일</th>
		<th>주소</th>
		<th>메모</th>
		<th>상세보기</th>
	</tr>
<c:forEach items="${list.content}" var="member">
	<tr>
		<td>${member.id}</td>
		<td>${member.name}</td>
		<td>${member.email}</td>
		<td>${member.addr}</td>
		<td>${member.memo}</td>
		<td> <a href="${member.id}">상세보기 </a></td>
	</tr>
</c:forEach>
</table>
  <ul class="pagination pagination-sm">
	    <li class="page-item"><a class="page-link" href="?page=${list.number-1}">이전</a></li>
	    <li class="page-item"><a class="page-link" href="?page=${list.number+1}">다음</a></li>
  </ul>
</div>
</body>
</html>