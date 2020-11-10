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
<!-- 글 상세보기-->
	<div class="col-bg-6">
	<h3>글쓰기</h3>
	<form action="boardUpdate" method="post">
	<input type="hidden" value="${board.num}" id="num" name="num">
	  <div class="form-group">
	    <label for="writer">작성자:</label>
	    <input type="text" value="${board.writer}" id="writer" name ="writer" class="form-control" readonly="readonly">
	  </div>
	  
	  <div class="form-group">
	    <label for="title">제목:</label>
	    <input type="text" value="${board.title}" id="title" name ="title" class="form-control">
	  </div>
	
	  <div class="form-group">
	    <label for="content">내용:</label>
	    <textarea class="form-control" rows="5" id="content" name="content">${board.content}</textarea>
	  </div>
	
	  <div class="form-group">
	    <label for="password">비밀번호:</label>
	    <input type="text" value="${board.password}" id="password" name ="password" class="form-control">
	  </div>
	  
	  <input type="button" id="updateBtn" name="updateBtn" value="글수정" class="btn btn-warning">
	  <input type="button" id="deleteBtn" name="deleteBtn" value="글삭제"  class="btn btn-danger"><br/><br/>
	</form>
	</div> 
<!-- 글 상세보기 끝 -->
<!-- 댓글 쓰기 -->
  <div align="center" class="form-group">
	<form action="cInsert" method="post">
		<input type="hidden" value="${board.num}" id="num" name="num">
		<textarea class="form-control" rows="2" id="msg" name="msg"></textarea>
		<input type="button" value="댓글쓰기" id="commentBtn" class="btn btn-sm btn-outline-primary">
	</form>
  </div>
<!-- 댓글 쓰기 끝-->
<!-- 댓글 목록 
	<div align="center" class="from-group" id="commentResult" name="commentResult">
	</div>-->

<!-- 댓글목록: 객체관계 매핑으로 가져오기. StarterBoard의 엔티티를 설정할때 이미 댓글목록을 comments 객체로 가져왔음. board로 맵핑되었으니 board.comments로 불러올 수 있음 -->	
	<div>
	<c:forEach items="${board.comments}" var="bc">
		<table class="table table-borderless">
			<tr>
				<td>${bc.cnum}</td>
				<td>${bc.content}</td>
				<td>${bc.regdate}</td>
			</tr>
		</table>
	</c:forEach>
	</div>
	
	
	
</div>
<script src="/js/board.js"></script>
</body>
</html>