<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  <c:choose>
	<c:when test="${empty sessionScope.sessionDto }">
	  <ul class="navbar-nav">
	    <li class="nav-item active">
			<a href="/board7/boardList" class="nav-link">글목록</a>
	    </li>
	    <li class="nav-item">
			<a href="/board7/member/login" class="nav-link">Login</a>
	    </li>
	    <li class="nav-item">
			<a href="/board7/member/join" class="nav-link">Join Us</a>
	    </li>
	  </ul>
	</c:when>						
	<c:otherwise>
	  <ul class="navbar-nav">
	    <li class="nav-item active">
			<a href="/board7/boardList" class="nav-link">글목록</a>
	    </li>
	    <li class="nav-item">
			<a href="/board7/member/login" class="nav-link">Login</a>
	    </li>
	    <li class="nav-item">
			<a href="" class="nav-link">Logout</a>
	    </li>
	  </ul>
	</c:otherwise>
  </c:choose>
</nav>