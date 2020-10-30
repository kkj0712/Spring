<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/include.jsp" %>

<body>
<div class="container">
 <h3>추가하기</h3>
 <form action="boardInsert" method="post">
  <div class="form-group">
    <label for="writer">작성자:</label>
    <input type="text" id="writer" name ="writer" class="form-control">
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

  <input type="submit" value="제출" class="btn btn-default">
   <input type="button" value="목록" onclick="location.href='boardList'" class="btn btn-default" >
 </form>
</div>
</body>
</html>