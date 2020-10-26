<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="/board/resources/js/board.js"></script>
</head>
<body>
<h2>글작성</h2>
<form action="boardInsert" method="post">
      <label>글쓴이</label>
    <div class="form-group">
      <input type="text" size="20" id="writer" name="writer" >
    </div>
      <label>제목</label>
    <div class="form-group">
      <input type="text" size="37" id="title" name="title" >
    </div>
      <label>내용</label>
    <div class="form-group">
      <textarea rows="5" cols="40" id="content" name="content"></textarea>
    </div>
    <div class="form-group">
      <label>비밀번호</label>
      <input type="password" size="20" id="password" name="password" >
    </div>
    <br/>
    	<input type="button" id="submit" name="submit" value="입력">
    	<input type="reset" value="취소">
</form>

<!-- 검색 영역 -->
<div align="right">
<form name="search" id="search">
	<select name="field" id="field">
		<option value="writer">글쓴이</option>
		<option value="title">제목</option>
	</select>
	<input type="text" name="word" id="word">
	<input type="button" value="찾기" id="btnSearch">
</form>
</div> <!-- 검색 영역 끝-->
<br/>
<!-- 갯수 출력 count-->
<div id="countArea"></div>
<!-- 전체보기 결과값 data(list)-->
<div id="listArea" align="center">
	<table border="1">
		<thead></thead>
		<tbody></tbody>
	</table>
</div>

<!-- 상세보기 view -->
<div id="viewArea" align="center"></div>

<!-- 페이징 영역 paging-->
<div id="pageArea" align="center"></div>

</body>
</html>