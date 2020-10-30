<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/include.jsp" %>
<body>
<div class="container">

<h3>로그인</h3>
  <div class="form-group">
    <label for="id">아이디:</label>
    <input type="text" id="id" name ="id" class="form-control">
  </div>
  
  <div class="form-group">
    <label for="pass">비밀번호:</label>
    <input type="text"  id="pass" name="pass" class="form-control">
  </div>
  
  <input type="button" value="로그인" id="btnLogin">
  
 </div>
  
  <script>
  $("#btnLogin").click(function(){
		$.ajax({
			type:"post",
			url:"login",
			data:{"id":$("#id").val(), "pass":$("#pass").val()},			
		})
		.done(function(resp){
			if(resp=="no"){
				alert("회원이 아닙니다. 회원가입하세요");
				location.href="join";
			}else if(resp=="success"){
				alert("성공");
				location.href="/board7/boardList";
			}else{
				alert("비밀번호를 확인하세요");
			}
		})
		
  })
  </script>
</body>
</html>