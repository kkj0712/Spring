<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="insert">추가하기</a>/<a href="list">전체보기</a><br/>
<hr>
<c:forEach items="${memberlist}" var="member">
아이디: <a href="view?id=${member.id}">${member.id}</a><br/>
비밀번호: ${member.pass}<br/>
성명: ${member.name}<br/>
주소: ${member.addr}<br/>
메모: ${member.memo}<br/>
가입일: ${member.reg_date}<br/><br/>
</c:forEach>
<form action="list">
	<select name = "field" id = "field">
		<option value = "id">아이디</option>
		<option value = "name">이름</option>		
	</select>
	<input type = "text" name = "word" id = "word">
	<input type = "submit" value = "검색" > 
</form>
</body>
</html>