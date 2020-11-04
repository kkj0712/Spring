let member={
	init:function(){
		$("#btnDelete").on("click", ()=>{
			this.delete();
		});
	},
	
	delete: function(){
		alert("delete");
		$.ajax({
			type:"DELETE",
			url: $("#id").text(),
		}).done(function(resp){
			alert(resp+"삭제가 완료되었습니다.");
		})
		.fail(function(error){
			alert(error);
		});
	}
}
member.init();