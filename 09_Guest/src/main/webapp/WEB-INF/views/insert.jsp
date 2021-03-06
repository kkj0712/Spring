<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="/myguest/resources/guest.js"></script>
</head>
<body>
<form action="gInsert" method="post">
<table align="center" width=900px>
	<tr>
		<td align="center">글쓴이</td>
		<td>
			<input type="text" size="20" maxlength="20" id="name" name="name">
		</td>
	</tr>
	<tr>
		<td align="center">내용</td>
		<td>
			<input type="text" size="70" maxlength="70" id="content" name="content">
		</td>
	</tr>
	<tr>
		<td align="center">평가</td>
		<td>
			<input type="radio" name="grade" value="excellent" checked>아주잘함(excellent)
			<input type="radio" name="grade" value="good">잘함(good)
			<input type="radio" name="grade" value="normal">보통(normal)
			<input type="radio" name="grade" value="fail">노력(fail)
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="button" id="submit" name="submit" value="입력">
			<input type="reset" value="취소">
		</td>
	</tr>
</table>
</form>

<!-- 검색 영역 -->
<div align="right">
<form name="search" id="search">
	<select name="field" id="field">
		<option value="name">이름</option>
		<option value="content">내용</option>
	</select>
	<input type="text" name="word" id="word">
	<input type="button" value="찾기" id="btnSearch">
</form>
</div> <!-- 검색 영역 끝-->

<hr>

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
<div id="pageArea" align="center">

</div>

</body>
</html>