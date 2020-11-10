let board={
	init:function(){
		//게시물 수정
		$("#updateBtn").on("click",()=>{
			this.update();
		});
		//게시물 삭제
		$("#deleteBtn").on("click",()=>{
			this.delete();
		});
		//댓글 목록
		//this.commentList();
		
		//댓글 쓰기
		$("#commentBtn").on("click",()=>{
			this.commentInsert();
		});
	},
	//게시물 수정
	update:function(){
		var dataParam={
			"num":$("#num").val(),
			"writer":$("#writer").val(),
			"password":$("#password").val(),
			"title":$("#title").val(),
			"content":$("#content").val()
		}
		var num=$("#num").val();
		$.ajax({
			type:"PUT",
			url: num+"/update",
			data:JSON.stringify(dataParam),
			contentType: "application/json;charset=utf-8",
		})
		.done(function(resp){
			alert("글 수정 완료");
			location.href="/boardList";
		})
		.fail(function(error){
			alert("error"+error);
		})
	},//update
	
	//게시물 삭제
	delete:function(){
		var num=$("#num").val();
		$.ajax({
			type:"DELETE",
			url: num+"/delete",
			data: JSON.stringify($("#num").val()),
			contentType:"application/json;charset=utf-8",
		})
		.done(function(resp){
			alert("글 삭제 완료");
			location.href="/boardList";
		})
		.fail(function(error){
			alert(error+"error");
		})
	}, //delete
	
	//댓글 목록=> 현재 사용 안함.
	commentList:function(){
		var num=$("#num").val();
		var bnum=$("#num").val();
		$.ajax({
			type:"get",
			url: "/reply/cList",
			data: {"bnum":$("#num").val()}
		})
		.done(function(resp){
			var htmlStr="";
			$.each(resp, function(key, value){
				htmlStr+="<tr>";
				htmlStr+="<td>"+value.cnum+"</td>";
				htmlStr+="<td>"+value.content+"</td>";
				htmlStr+="<td>"+value.regdate+"</td>";
				htmlStr+="</tr>";
			})
			$("#commentResult table").html(htmlStr);
		})
		.fail(function(error){
			alert("댓글 불러오기 실패");
		})
	},//commentList
	
	//댓글쓰기
	commentInsert:function(){
		var dataParam={
			"bnum":$("#num").val(),
			"content":$("#msg").val()
		};
		$.ajax({
			type:"post",
			url: "/reply/cInsert",
			data: JSON.stringify(dataParam),
			contentType: 'application/json;charset=uft-8'
		})
		.done(function(){
			alert("등록완료");
			location.href="/view/"+$("#num").val()
		})
		.fail(function(error){
			alert("댓글입력 실패");
		})
	} //commentInsert
}//board
board.init();