let member={
	init:function(){
		$("#btnDelete").on("click", ()=>{ //람다함수를 왜 썼을까? 콜백함수에서 콜백이 되었을경우에 this는 최상위 window객체를 가리키는데 람다함수를 쓰면 this는 그 자신을 가리킴. 
			this.delete();
		});
		
		$("#btnUpdate").on("click", ()=>{ //람다함수를 왜 썼을까? 콜백함수에서 콜백이 되었을경우에 this는 최상위 window객체를 가리키는데 람다함수를 쓰면 this는 그 자신을 가리킴. 
			this.update();
		});
	},
	
	update:function(){
		var dataParam={
			"name":$("#name").val(),
			"addr":$("#addr").val(),
			"id":$("#id").val(),
			"password":$("#password").val(),
			"email":$("#email").val(),
			"memo":$("#memo").val()
		}
		var id=$("#id").val();
			//put 방식은 contentType을 적어줘야함. 그리고 그걸 적으려면 stringify 필요 
		$.ajax({
			type:"PUT",
			url: "/update/"+id, //PathVariable로 가는거니까 id를 뒤에 달고감
			data: JSON.stringify(dataParam),
			contentType:"application/json;charset=utf-8",
		})
		.done(function(resp){
			alert(resp+"수정 완료");
			location.href="/list";
		})
		.fail(function(error){
			alert(error+"error");
		})
	}, //update
	
	delete:function(){
		$.ajax({
			type:"DELETE",
			url: $("#id").text(), //val()아니고 글자니까 text() => PathVariable로 받음
		})
		.done(function(resp){
			alert(resp+"번 글이 삭제");
			location.href="/list";
		})
		.fail(function(error){
			alert(error+"error");
		})
	}//delete
} //member
member.init();