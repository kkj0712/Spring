<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"  uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<body>
<div class="container">
 <h3>추가하기</h3>
 <form action="" method="post">
  <div class="form-group">
    <label for="writer">작성자:</label>
    <!-- 암호화를 위해 hidden 값으로 반드시 parameterName과 token을 넘겨줘야함 -->
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
    <!-- 이미 로그인을 하고 insert.jsp로 넘어왔기 때문에 작성자는 따로 칸을 만들지 않는다. 인증된 접근자 (principal)의 아이디가 보여진다. -->
    <input type="text" id="username" name ="writer" class="form-control" readonly="readonly" value='<sec:authentication property="principal.username"/>'>
  </div>
  
  <div class="form-group">
    <label for="password">비밀번호:</label>
    <input type="text"  id="password" name="password" class="form-control">
  </div>
  
  <div class="form-group">
    <label for="title">제목:</label>
    <input type="text" id="title" name="title" class="form-control">
  </div>
  
  <div class="form-group">
    <label for="content">내용:</label>
    <textarea class="form-control" rows="5" id="content" name="content"></textarea>
  </div>  

  <input type="submit" value="제출" class="btn btn-primary">
  <input type="button" value="목록" onclick="location.href='boardList'" class="btn btn-default" >
 </form>
</div>
</body>
</html>