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
<div class="col-bg-6">
<h3>회원리스트</h3>
<table class="table table-striped">
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>이름</th>
		<th>주소</th>
	</tr>
	<c:forEach items="${ulist.content}" var="user">
	<tr>
		<td>${user.unum}</td>
		<td><a href="${user.unum}">${user.userid}</a></td>
		<td>${user.name}</td>
		<td>${user.addr}</td>
	</tr>
	</c:forEach>
</table>
</div>
<div class="text-xs-center">
  <ul class="pagination pagination-sm">
	    <li class="page-item"><a class="page-link" href="?page=${blist.number-1}">이전</a></li>
	    <li class="page-item"><a class="page-link" href="?page=${blist.number+1}">다음</a></li>
  </ul>
</div>
</div>
</body>
</html>