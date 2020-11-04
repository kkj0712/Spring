<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/include.jsp" %>
<body>
<div class="container">
<h3>${board.writer}의 글</h3>
  <div class="form-group">
    <label for="num">글 번호:</label>
    <input type="text" id="num" name="num" value="${board.num }" class="form-control" readonly>
  </div>
  
  <div class="form-group">
    <label for="writer">작성자:</label>
    <input type="hidden" id="prin" name="prin" value='<sec:authentication property="principal.username"/>'>
    <input type="text" id="writer" name ="writer" class="form-control" value="${board.writer}" readonly>
  </div>
  <div class="form-group">
    <label for="password">비밀번호:</label>
    <input type="text"  id="password" name="password" class="form-control" value="${board.password}" readonly>
  </div>
  <div class="form-group">
    <label for="regdate">작성일:</label>
    <input type="text"  id="regdate" name="regdate" class="form-control" value="${board.regdate}" readonly>
  </div>
  <div class="form-group">
    <label for="hitcount">조회수:</label>
    <input type="text" id="hitcount" name="hitcount" class="form-control" value="${board.hitcount}" readonly>
  </div>
  <div class="form-group">
    <label for="title">제목:</label>
    <input type="text" id="title" name="title" class="form-control" value="${board.title}" readonly>
  </div>
  <div class="form-group">
    <label for="content">내용:</label>
    <textarea class="form-control" rows="5" id="content" name="content" readonly>${board.content}</textarea>
  </div>

  <div class="form-group">
    <input type="button" value="수정하기" class="btn btn-primary"  onclick="location.href='update?num=${board.num}'" >
    <input type="button" value="삭제하기" class="btn btn-secondary"  onclick="location.href='boardDelete?num=${board.num}'" >
  </div>
</div>

<div align="center" class="form-group">
	<textarea rows="5" cols="50" id="msg" name="msg" class="from-control"></textarea>
	<input type="button" value="댓글쓰기" id="comment" class="btn btn-outline-info">
</div>

<div id="area"></div>

<script>
//post방식은 암호화시켜서 넘어가야하므로 csrf값들을 달고 가야함
var csrfHeaderName = "${_csrf.headerName}";
var csrfTokenValue = "${_csrf.token}";

//Ajax spring security header...
 $(document).ajaxSend(function(e, xhr, options){
	xhr.setRequestHeader(csrfHeaderName, csrfTokenValue);
	}) 
	
	var init = function(){
		$.ajax({
			type:"get",
			url:"/security11/reply/commentList",
			data: {"bnum":$("#num").val()}
		})
		.done(function(resp){
			var htmlStr="" ;
			$.each(resp, function(key,value){
				htmlStr+="<table>";
				htmlStr+="<tr>";
				htmlStr+="<td>"+value.cnum+"</td>";
				htmlStr+="<td>"+value.content+"</td>";
				htmlStr+="<td>"+value.regdate+"</td>";
			//댓글을 쓴 commentspringboard의 userid와 현재 로그인한 user가 같으면 삭제 버튼
			if($("#prin").val()==value.userid){
				htmlStr+="<td><a href='javascript:fdel("+value.cnum+")'>삭제</a></td>";
			}
				htmlStr+="</tr>";		
				htmlStr+="</table>";		
			})
			$("#area").html(htmlStr);
		})
		.fail(function(error){
			alert("실패");
		})		
	}

	$("#comment").click(function(){
		var data={
			"bnum":$("#num").val(),
			"content":$("#msg").val(),
			"userid": $("#prin").val()
		};
		$.ajax({
			type:"post",
			url:"/security11/reply/commentInsert",
			contentType:'application/json;charset=utf-8',
			data:JSON.stringify(data)
		}).done(function(){
			alert("등록완료")
			init();
		}).fail(function(error){
			alert("error");
		})
	});

	function cDelete(cnum){
		if(confirm(cnum+"의 댓글을 삭제하시겠습니까?")){
			$.get("/security11/reply/commentDelete", {"cnum":cnum},
				function(resp){
					if(resp=='success'){
						init();
					}
				}
			)
		}
	}

	function fdel(cnum){
		$.ajax({
			type:'DELETE',
			url:"/security11/reply/del/"+cnum,
			dataType:'json',
		})
		.done(function(resp){
			alert(resp+"글 삭제");
			init();
		})
		.fail(function(error){
			alert("글 삭제 실패");
		})
	}
	init();
</script>
</body>
</html>