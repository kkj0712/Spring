<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div class="container"><br/>
<h3>상세보기</h3>
<div class="form-group">
	<form>
	<label for="id">번호</label>
	<input type="text" class="form-control" id="id" name="id" value="${member.id}" readonly="readonly">
	<label for="name">이름</label>
		<input type="text" class="form-control" id="name" name="name" value="${member.name}" readonly="readonly">
	<label for="password">비밀번호</label>
		<input type="text" class="form-control" id="password" name="password" value="${member.password}" readonly="readonly">
	<label for="email">이메일</label>
		<input type="text" class="form-control" id="email" name="email" value="${member.email}" readonly="readonly">
	<label for="addr">주소</label>
		<input type="text" class="form-control" id="addr" name="addr" value="${member.addr}" readonly="readonly">
	<label for="memo">메모</label>
		<input type="text" class="form-control" id="memo" name="memo" value="${member.memo}" readonly="readonly">
	<br/>
	<a href="${member.id}/update">수정하기</a>
	<button id="btnDelete" class="btn btn-danger">글삭제</button>
	</form>
<!-- 컴포넌트 들이 다 인식하고 나서 자바스크립트가 실행되어야하므로 밑에 적음. 
만약에 위에 적으면 자바스크립트에서 $(document).ready(function(){}을 적고 그 안에 함수 적어야함 -->
<script src="/js/member1.js"></script>
</body>
</html>