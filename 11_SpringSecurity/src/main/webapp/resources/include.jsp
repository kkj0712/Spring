<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"  uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<sec:authorize access="isAnonymous()">
	  <ul class="navbar-nav">
	    <li class="nav-item active">
			  <a href="/security11/customLogin" style="margin-right: 10px">로그인</a>
	    </li>
	    <li class="nav-item">
			  <a href="/security11/board/insert">게시판 글쓰기</a>  
	    </li>
	  </ul>
	</sec:authorize>
	<sec:authorize access="isAuthenticated()">
	  <ul class="navbar-nav">
	    <li class="nav-item active">
			  <a href="/security11/customLogout">로그아웃</a>
			  <a href="/security11/board/list">게시판 글목록</a>  
	    </li>
	  </ul>
	</sec:authorize>
</nav>