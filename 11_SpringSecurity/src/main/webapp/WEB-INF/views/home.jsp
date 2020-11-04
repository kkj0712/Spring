<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"  uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>/sample/home page</h1>
<!-- 권한 없는 사람 -->
<sec:authorize access="isAnonymous()">
  <a href="/security11/customLogin">로그인</a>
  <a href="/security11/board/insert">게시판 글쓰기</a>  
  <a href="/security11/board/list">게시판 글목록</a>  
</sec:authorize>
<!-- 권한이 있는 사람 -->
<sec:authorize access="isAuthenticated()">
  <a href="/security11/customLogout">로그아웃</a>
  <a href="/security11/board/list">게시판 글목록</a>  
</sec:authorize>
</body>
</html>
