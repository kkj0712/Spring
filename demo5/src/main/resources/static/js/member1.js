let member={
	init:function(){
		$("#btnDelete").on("click", ()=>{ //람다함수를 왜 썼을까? 콜백함수에서 콜백이 되었을경우에 this는 최상위 window객체를 가리키는데 람다함수를 쓰면 this는 그 자신을 가리킴. 
			this.delete();
		});
	},
	delete:function(){
		alert("delete");
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
	}
}
member.init();