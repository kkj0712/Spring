<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
$(function(){
	//insert 실행할때 list load 하기
	getData(1,"","");

	//insert
	$("#submit").on("click",function(){
		var name=$("#name").val();
		var content=$("#content").val();
		var grade=$("input:radio[name=grade]:checked").val();
		var postString="name="+name+"&content="+content+"&grade="+grade;

		$.ajax({
			type: "post",
			url:  "gInsert",
			data: postString,
			success: function(resp){
				$("#listArea").html(resp);
			},
			error: function(e){
				alert("error:"+e)
			}
		})
	})//submit
})//function

function getData(pageNum,field, word){
	$.get("gList", 	
			{"pageNum":pageNum, "field":field, "word":word},
			function(resp){
				$("#listArea").html(resp);
		 }//callback function
	  );//get
}//funciton

//상세보기
function fview(num){
	$.get("gView", 
			{"num":num},
			function(resp){
				resp=JSON.parse(resp);
				var htmlStr="";
				htmlStr+=resp.name+"<br>";
				htmlStr+=resp.content+"<br>";
				htmlStr+=resp.grade+"<br>";
				htmlStr+=resp.created+"<br>";
				htmlStr+=resp.ipaddr+"<br>";
				$("#viewArea").html(htmlStr);
			} //callback function
		); //get
}

//삭제하기
function fdelete(num, name){
	if(confirm("["+name+"]의 게시글을 정말 삭제할까요?")){
		$.get("gDelete?num="+num, 
				function(resp){
				$("#listArea").html(resp);
			} //callback function
		); //get
	}//if
}//function

</script>
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
<hr>
<div align="right">
<form name="search" id="search">
	<select name="field" id="field">
		<option value="name">이름</option>
		<option value="content">내용</option>
	</select>
	<input type="text" name="word" id="word">
	<input type="button" value="찾기" id="btnSearch">
</form>
</div>

<!--추가한 결과값을 돌려줌-->
<div id="listArea"></div>
<hr>

<!-- 상세보기 -->
<div id="viewArea"></div>


</body>
</html>