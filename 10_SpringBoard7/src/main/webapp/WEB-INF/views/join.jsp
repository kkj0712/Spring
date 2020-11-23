<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/include.jsp" %>
<body>
<div class="container">

 <h3>회원가입 하기</h3>
 <form action="/board7/member/join" method="post">
  <div class="form-group">
    <label for="id">아이디:</label>
    <input type="text" id="id" name ="id" class="form-control">
    <input type="button" id="btnIdCheck" value="중복체크" >
    <span id="idcheck"></span>
  </div>
  
  <div class="form-group">
    <label for="pass">비밀번호:</label>
    <input type="text"  id="pass" name="pass" class="form-control">
  </div>
  
  <div class="form-group">
    <label for="name">이름:</label>
    <input type="text"  id="name" name="name" class="form-control">
  </div>
  
  <div class="form-group">
    <label for="addr">주소:</label>
    <input type="text"  id="addr" name="addr" class="form-control">
  </div>

  <input type="button" id="btnJoin" value="회원가입">
  
  </form>
 </div>
 
 
  <script>
	$("#btnJoin").click(function(){
		if($("#id").val()==null||$("#id").val()==""){
			alert("아이디를 입력하세요");
		}
		if($("#pass").val()==null||$("#pass").val()==""){
			alert("비밀번호를 입력하세요");
		}
		if($("#name").val()==null||$("#name").val()==""){
			alert("이름 입력하세요");
		}
		if($("#addr").val()==null||$("#addr").val()==""){
			alert("주소를 입력하세요");
		}
		
		var data={
				"id":$("#id").val(),
				"pass":$("#pass").val(),
				"name":$("#name").val(),
				"addr":$("#addr").val()
		};

		$.ajax({
			type:"post",
			url:"/board7/member/join",
			contentType:'application/json;charsert=utf-8', //json형태로 돌려주려면 controller에서 @RequestBody로 파라미터값을 넘김
			data:JSON.stringify(data)
		})
		.done(function(resp){
			if(resp=="success"){
				alert("반갑습니다")
				location.href="login";
			}

		})
		.fail(function(error){
			alert("회원가입 실패");
		})
	});
	
	
	
	
	$("#btnIdCheck").click(function(){
		if($("#id").val()==null||$("#id").val()==""){
			alert("아이디를 입력하세요");
		}
		
		$.ajax({
			type:"get",
			url:"/board7/member/idcheck",
			data:{id:$("#id").val()}
		})
		.done(function(resp){
			if(resp==0){
				$("#idcheck").html("사용가능한 아이디");
			}else{
				$("#idcheck").html("사용 불가능한 아이디");
				$("#id").focus();
				$("#id").val("");
			}
		})


		
	});
	
	
  </script>
</body>
</html>