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
<h3>Starter Board</h3>
<table class="table table-striped">
	<tr>
		<th>번호</th>
		<th>작성자</th>
		<th>제목</th>
		<th>조회수</th>
	</tr>
	<c:forEach items="${blist.content}" var="b">
	<tr>
		<td>${b.num}</td>
		<td>${b.writer}</td>
		<td><a href="view/${b.num}">${b.title}</a></td>
		<td>${b.hitcount}</td>
	</tr>
	</c:forEach>
</table>
<div class="text-xs-center">
  <ul class="pagination pagination-sm">
	    <li class="page-item"><a class="page-link" href="?page=${blist.number-1}">이전</a></li>
	    <li class="page-item"><a class="page-link" href="?page=${blist.number+1}">다음</a></li>
  </ul>
</div>
</div>
</div>
</body>
</html>