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
<h3>상세보기</h3>
이름: ${user.name}<br/>
아이디: ${user.id}<br/>
성별: ${user.gender}<br/>
직업: ${user.job}<br/><br/>
<input type="button" value="수정" onclick="location.href='update.go?id=${user.id}'">
<input type="button" value="삭제" onclick="location.href='personDelete.go?id=${user.id}'">
</body>
</html>