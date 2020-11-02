<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>/sample/all page</h1>
<sec:authorize access="isAnonymous()">
	<a href="/security/customLogin">로그인</a>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
	<a href="/security/customLogout">로그아웃</a>
</sec:authorize>
</body>
</html>
