<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>리스트</h3>
<h3><a href="mInsert">추가</a></h3>
<table>
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>주소</th>
		<th>상세보기</th>
	</tr>
<c:forEach items="${list}" var="list">
	<tr>
		<td>${list.id}</td>
		<td>${list.name}</td>
		<td>${list.addr}</td>
		<td> <a href="${list.id}">상세보기 </a></td>
	</tr>
</c:forEach>
</table>
</body>
</html>