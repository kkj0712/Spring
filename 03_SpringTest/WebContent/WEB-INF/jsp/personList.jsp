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
<a href="insert.go">추가하기</a>/전체보기<br/>
<c:forEach items="${personlist}" var="user">
이름: ${user.name}<br/>
아이디: <a href="detail.go?id=${user.id}">${user.id}</a><br/>
성별: ${user.gender}<br/>
직업: ${user.job}<br/><br/>
</c:forEach>
</body>
</html>