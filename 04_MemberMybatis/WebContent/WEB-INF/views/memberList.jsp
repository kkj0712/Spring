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
<a href="insert.my">추가하기</a>/전체보기<br/>
<c:forEach items="${memberlist}" var="member">
아이디: <a href="view.my?id=${member.id}">${member.id}</a><br/>
비밀번호: ${member.pass}<br/>
성명: ${member.name}<br/>
주소: ${member.addr}<br/>
메모: ${member.memo}<br/>
가입일: ${member.reg_date}<br/><br/>
</c:forEach>
</body>
</html>