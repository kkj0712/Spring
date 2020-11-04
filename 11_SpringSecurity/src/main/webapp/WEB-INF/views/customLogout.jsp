<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> Logout Page</h1>

<form action="/security11/customLogout" method='post'>
<!-- csrf란 공격을 막기위해서 파라미터 이름과 토큰을 달고감 -->
<input type="hidden"name="${_csrf.parameterName}"value="${_csrf.token}"/>
<button>로그아웃</button>
</form>

</body>
</html>