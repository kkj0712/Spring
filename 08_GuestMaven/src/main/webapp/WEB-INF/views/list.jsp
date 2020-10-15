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
<h5>평가 리스트(<span id="cntSpan">${count}</span>)</h5>
<table class="table table-hover">
	<thead>
		<tr>
			<th>번호</th>
			<th>seq</th>
			<th>글쓴이</th>
			<th>평가</th>
			<th>작성일</th>
			<c:if test="${sessionScope.login!=null}">
			<th>삭제</th>
			</c:if>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${guestlist}" var="guest" varStatus="st">
		<tr>
			<td>${guest.num}</td>
			<td>${guest.name}</td>
			<td>${guest.grade}</td>
			<td>${guest.created}</td>
			<c:if test="${sessionScope.login!=null}">
				<td>삭제</td>
			</c:if>
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>