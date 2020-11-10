<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container"><br/>
<div class="col-bg-6">
<h3>회원가입</h3>
<form action="insert" method="post">
  <div class="form-group">
    <label for="userid">아이디:</label>
    <input type="text" id="userid" name ="userid" class="form-control">
    <input type="button" id="idCheckBtn" name ="idCheckBtn" value="중복확인" class="btn btn-outline-info">
  </div>
  
  <div class="form-group">
    <label for="password">비밀번호:</label>
    <input type="text" id="password" name ="password" class="form-control">
  </div>

  <div class="form-group">
    <label for="name">이름:</label>
    <input type="text" id="name" name ="name" class="form-control">
  </div>

  <div class="form-group">
    <label for="addr">주소:</label>
    <input type="text" id="addr" name ="addr" class="form-control">
  </div>
  
  <div class="form-group">
    <label for="content">메모:</label>
    <textarea class="form-control" rows="5" id="memo" name="memo"></textarea>
  </div>
  
	<input type="submit" value="회원가입" class="btn btn-primary">
</form>
</div>
</div>
<script src="/js/starter.js"></script>
</body>
</html>