<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
<h2>개인정보 수정</h2>
<form action="member_update.me" method="post">
<input type="hidden" name="id" id="id" value="${user.id}">
<table>
<tr>
	<td>아이디</td>
	<td>${user.id}</td>
</tr>
<tr>
	<td>비밀번호</td>
	<td><input type="password" name="pass" id="pass" value="${user.pass}"></td>
</tr>
<tr>
	<td>성명</td>
	<td><input type="text" name="name" id="name" value="${user.name}"></td>
</tr>
<tr>
	<td>주소</td>
	<td><input type="text" name="addr" id="addr" value="${user.addr}"></td>
</tr>
<tr>
	<td>메모</td>
	<td><textarea rows="5" cols="25" name="memo" id="memo" >${user.memo}</textarea></td>
</tr>
<tr>
	<td colspan="2" align="center">
	<input type="submit" value="확인">
	<input type="reset" value="취소"></td>
</tr>
</table>
</form>
</body>
</html>