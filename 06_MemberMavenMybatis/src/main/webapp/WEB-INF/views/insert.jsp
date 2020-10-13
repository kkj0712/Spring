<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원가입</h2>
<form action="insert" method="post">
<table>
<tr>
	<td>아이디</td>
	<td><input type="text" name="id" id="id"></td>
</tr>
<tr>
	<td>비밀번호</td>
	<td><input type="password" name="pass" id="pass"></td>
</tr>
<tr>
	<td>성명</td>
	<td><input type="text" name="name" id="name"></td>
</tr>
<tr>
	<td>주소</td>
	<td><input type="text" name="addr" id="addr"></td>
</tr>
<tr>
	<td>메모</td>
	<td><textarea rows="5" cols="25" name="memo" id="memo"></textarea></td>
</tr>
<tr>
	<td colspan="2" align="center">
	<input type="submit" value="가입">
	<input type="reset" value="취소"></td>
</tr>
</table>
</form>
</body>
</html>