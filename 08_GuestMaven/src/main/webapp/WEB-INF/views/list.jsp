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
			<th>seq</th>
			<th>글쓴이</th>
			<th>평가</th>
			<th>작성일</th>
			<th>삭제</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${guestlist}" var="guest" varStatus="st">
		<tr>
			<td>${guest.num}</td>
			<td><a href="javascript:fview(${guest.num})">${guest.name}</a></td>
			<td>${guest.grade}</td>
			<td>${guest.created}</td>
				<td>
					<a href="javascript:fdelete(${guest.num},'${guest.name}')">삭제</a>
				</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<!-- 페이징 처리 기능 추가 -->
<div align="center">
${pageHtml}
</div>

</body>
</html>