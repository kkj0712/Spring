$(function(){
	getData(1,"","");
	
	//추가하기
	$("#submit").on("click", function(){
		var writer=$("#writer").val();
		var title=$("#title").val();
		var content=$("#content").val();
		var password=$("#password").val();
		var postString="writer="+writer+"&title="+title+"&content="+content+"&password="+password;
		
		$.ajax({
			type: "post",
			url: "boardInsert",
			data: postString,
			success: function(resp){
				getData(1,"","");
				$("#writer").val("");
				$("#title").val("");
				$("#content").val("");
				$("#password").val("");
			},
			error: function(e){
				alert("error:"+e)
			}
		})//ajax
	})//submit
});//ready

function createHtmlStr(item){
	return `<tr>
		<td>${item.num}</td>
		<td><a href="javascript:fview(${item.num})">${item.writer}</a></td>
		<td>${item.title}</td>
		<td>${item.content}</td>
		<td>${item.regdate}</td>
		<td><a href="javascript:fdelete(${item.num}, '${item.writer}')">삭제</a></td>
	  </tr>
	`
}

function getData(pageNum, field, word){
	$.get("boardList", {"pageNum":pageNum, "field":field, "word":word}, 
			function(resp){
				//개수출력
				var countStr="<div align='center'>총 게시물 수: "+resp.count+"</div>";
				$("#countArea").html(countStr);
				
				//전체보기 제목부분
				var htmlTitle="<table><thead><tr>";
				htmlTitle+="<th>seq</th>";
				htmlTitle+="<th>글쓴이</th>";
				htmlTitle+="<th>제목</th>";
				htmlTitle+="<th>내용</th>";
				htmlTitle+="<th>작성일</th>";
				htmlTitle+="<th>삭제</th></tr></thead>";
				$("#listArea thead").html(htmlTitle); 
				
				//내용부분
				var container=document.querySelector("#listArea tbody");
				container.innerHTML=resp.list.map(item=>createHtmlStr(item)).join('').replace(/null/gi,"");
				
				//페이징내용
				$("#pageArea").html(resp.pageHtml);
		} //callback
	) //get
} //function

function fview(num){
	$.get("boardView", {"num":num},
		function(resp){
			var htmlStr="";
			htmlStr+=resp.writer+"<br>";
			htmlStr+=resp.title+"<br>";
			htmlStr+=resp.content+"<br>";
			htmlStr+=resp.regdate+"<br>";
			$("#viewArea").html(htmlStr);
		})
}

function fdelete(num, writer){
	if(confirm("["+writer+"]의 게시글을 정말 삭제하시겠습니까?")){
		$.get("boardDelete?num="+num,
				function(resp){
					if(resp=="success"){
						alert("삭제성공");
						getData(1,"","");
					}
			}//callback
		)//get
	}//if
}