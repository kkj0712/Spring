<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h3>회원정보</h3>
<form action="update" method="post">
<input type="hidden" value="${user.unum}" id="unum" name="unum">
  <div class="form-group">
    <label for="userid">아이디:</label>
    <input type="text" value="${user.userid}" readonly="readonly" id="userid" name ="userid" class="form-control">
  </div>
  
  <div class="form-group">
    <label for="password">비밀번호:</label>
    <input type="text" value="${user.password}" id="password" name ="password" class="form-control">
  </div>

  <div class="form-group">
    <label for="name">이름:</label>
    <input type="text" value="${user.name}" id="name" name ="name" class="form-control">
  </div>

  <div class="form-group">
    <label for="addr">주소:</label>
    <input type="text" value="${user.addr}" id="addr" name ="addr" class="form-control">
  </div>
  
  <div class="form-group">
    <label for="content">메모:</label>
    <textarea class="form-control" rows="5" id="memo" name="memo">${user.memo}</textarea>
  </div>
  
  <input type="button" id="updateBtn" name="updateBtn" value="수정" class="btn btn-warning">
  <input type="button" id="deleteBtn" name="deleteBtn" value="삭제"  class="btn btn-danger">
</form>
</div>
</div>
<script src="/js/starter.js"></script>
</body>
</html>