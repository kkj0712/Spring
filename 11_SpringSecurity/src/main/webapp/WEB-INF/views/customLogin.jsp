<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method='post' action="/security11/login">
    <div>
    <input type='text' name='username'>
  </div>
  <div>
    <input type='password' name='password' >
  </div>
  <div>
	<input name="remember-me" type="checkbox"> Remember Me  
  </div>
    <input type='submit'>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
    </form>
</body>
</html>