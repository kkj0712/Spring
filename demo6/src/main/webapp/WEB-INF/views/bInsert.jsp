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
<h3>글쓰기</h3>
<form action="boardInsert" method="post">
  <div class="form-group">
    <label for="writer">작성자:</label>
    <input type="text" id="writer" name ="writer" class="form-control">
  </div>
  
  <div class="form-group">
    <label for="title">제목:</label>
    <input type="text" id="title" name ="title" class="form-control">
  </div>

  <div class="form-group">
    <label for="content">내용:</label>
    <textarea class="form-control" rows="5" id="content" name="content"></textarea>
  </div>

  <div class="form-group">
    <label for="password">비밀번호:</label>
    <input type="text" id="password" name ="password" class="form-control">
  </div>
	<input type="submit" value="글쓰기" class="btn btn-info">
</form>
</div>
</div>
<script src="/js/board.js"></script>
</body>
</html>