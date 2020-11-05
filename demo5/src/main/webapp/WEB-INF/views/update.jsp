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
<h3>회원수정</h3>
<div class="form-group">
	<form>
	<label for="id">번호</label>
		<input type="text" class="form-control" id="id" name="id" value="${member.id}" readonly="readonly">
	<label for="name">이름</label>
		<input type="text" class="form-control" id="name" name="name" value="${member.name}">
	<label for="password">비밀번호</label>
		<input type="text" class="form-control" id="password" name="password" value="${member.password}">
	<label for="email">이메일</label>
		<input type="text" class="form-control" id="email" name="email" value="${member.email}">
	<label for="addr">주소</label>
		<input type="text" class="form-control" id="addr" name="addr" value="${member.addr}">
	<label for="memo">메모</label>
		<input type="text" class="form-control" id="memo" name="memo" value="${member.memo}">
	<!-- button태그는 기본적으로 submit 기능이 있어서 type에 다시 button을 적어줌 -->
	<br/>
	<button id="btnUpdate" type="button" class="btn btn-warning">글수정</button>
	</form>
</div>
</div>
<script src="/js/member1.js"></script>
</body>
</html>