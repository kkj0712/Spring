<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/include.jsp" %>

<body>
<div class="container">
<h3>${board.writer}의 글 수정하기</h3>
<form action="update" method="post"> 
<input type="hidden" name="num" value=${board.num }>
  <div class="form-group">
    <label for="writer">작성자:</label>
    <input type="text" id="writer" name ="writer" class="form-control" value="${board.writer}">
  </div>
  <div class="form-group">
    <label for="password">비밀번호:</label>
    <input type="text"  id="password" name="password" class="form-control" value="${board.password}">
  </div>
  <div class="form-group">
    <label for="regdate">작성일:</label>
    <input type="text"  id="regdate" name="regdate" class="form-control" value="${board.regdate}" readonly>
  </div>
  <div class="form-group">
    <label for="hitcount">조회수:</label>
    <input type="text" id="hitcount" name="hitcount" class="form-control" value="${board.hitcount}">
  </div>
  <div class="form-group">
    <label for="title">제목:</label>
    <input type="text" id="title" name="title" class="form-control" value="${board.title}">
  </div>
  <div class="form-group">
    <label for="content">내용:</label>
    <textarea class="form-control" rows="5" id="content" name="content">${board.content}</textarea>
  </div>  
  <input type="submit" value="수정완료" class="btn btn-default">
</form>
</div>

</body>
</html>