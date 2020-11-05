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
<h3>회원가입</h3>
<form action="mInsert" method="post">
  <div class="form-group">
    <label for="id">이름:</label>
    <input type="text" id="name" name ="name" class="form-control">
  </div>

  <div class="form-group">
    <label for="id">비밀번호:</label>
    <input type="text" id="password" name ="password" class="form-control">
  </div>
  
  <div class="form-group">
    <label for="id">이메일:</label>
    <input type="text" id="email" name ="email" class="form-control">
  </div>

  <div class="form-group">
    <label for="id">주소:</label>
    <input type="text" id="addr" name ="addr" class="form-control">
  </div>
  
  <div class="form-group">
    <label for="content">메모:</label>
    <textarea class="form-control" rows="5" id="memo" name="memo"></textarea>
  </div>
  
	<input type="submit" value="제출" class="btn btn-outline-info">
</form>
</div>
</body>
</html>