let user={
	init:function(){
		$("#updateBtn").on("click", ()=>{
			this.update();
		});
		$("#deleteBtn").on("click", ()=>{
			this.delete();
		});
		$("#idCheckBtn").on("click", ()=>{
			this.idCheck();
		});
	},
	
	update:function(){
		var dataParam={
			"unum":$("#unum").val(),
			"userid":$("#userid").val(),
			"password":$("#password").val(),
			"name":$("#name").val(),
			"addr":$("#addr").val(),
			"memo":$("#memo").val()
		}
		var unum=$("#unum").val();
		$.ajax({
			type:"PUT",
			url: "/update/"+unum, //PathVariable 이라서
			data: JSON.stringify(dataParam),
			contentType:"application/json;charset=utf-8",
		})
		.done(function(resp){
			alert(resp+" 회원정보 수정 완료");
			location.href="/list";
		})
		.fail(function(error){
			alert(error+"error");
		})
	},//update
	
	delete:function(){
		var dataParam={
		    "unum":$("#unum").val(),
			"userid":$("#userid").val()
			
		}
		$.ajax({
			type:"DELETE",
			url: "/delete/"+$("#unum").val(),
			data: JSON.stringify(dataParam),
			contentType:"application/json;charset=utf-8",
		})
		.done(function(resp){
			alert(resp+" 회원 삭제");
			location.href="/list";
		})
		.fail(function(error){
			alert(error+"error");
		})
	}, //delete
	
	idCheck:function(){
		$("#idcheck").html("");
		
		$.ajax({
			type:"get",
			url:"/idCheck",
			data:{userid:$("#userid").val()},
		})
		.done(function(resp){
			if(resp.trim()=="YES"){
				$("#idcheck").html("사용가능한 아이디");
			}else{
				$("#idcheck").html("사용 불가능한 아이디");
				$("#userid").focus();
				$("#userid").val("");
			}
		})
		.fail(function(error){
			alert("조회실패");
		})
	}
	
}//user
user.init();