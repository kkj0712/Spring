$(function(){
	getData(1, "", "");
	
	//추가하기
	$("#submit").on("click", function(){
		var name=$("#name").val();
		var content=$("#content").val();
		var grade=$("input:radio[name=grade]:checked").val();
		var postString="name="+name+"&content="+content+"&grade="+grade;
		
		$.ajax({
			type:"post",
			url:"gInsert",
			data: postString,
			success: function(resp){
				getData(1,"","");			
			},
			error: function(e){
				alert("error:"+e)
			}
		})//ajax
	})//submit
});//function

//템플릿 return 뒤에 써야지 하나의 문자열로 인식. 
function createHtmlStr(item){
	return `<tr>
		<td>${item.num}</td>
		<td><a href="javascript:fview(${item.num})">${item.name}</a></td>
		<td>${item.grade}</td>
		<td>${item.content}</td>
		<td>${item.created}</td>
		<td><a href="javascript:fdelete(${item.num},'${item.name}')">삭제</a></td>
	 </tr>
	`
}

function getData(pageNum, field, word){
	$.get("gList", {"pageNum":pageNum, "field":field, "word":word}, 
			function(resp){
				//개수출력
				var countStr="<div align='center'>총 게시물 수: "+resp.count+"</div>";
				$("#countArea").html(countStr);
				
				//전체보기 제목부분
				var htmlTitle="<table><thead><tr>";
				htmlTitle+="<th>seq</th>";
				htmlTitle+="<th>글쓴이</th>";
				htmlTitle+="<th>평가</th>";
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

//상세보기
function fview(num){
	$.get("gView", 
			{"num":num}, 
			function(resp){
				//resp=JSON.parse(resp);
				var htmlStr="";
				htmlStr+=resp.name+"<br>";
				htmlStr+=resp.content+"<br>";
				htmlStr+=resp.grade+"<br>";
				htmlStr+=resp.created+"<br>";
				htmlStr+=resp.ipaddr+"<br>";
				$("#viewArea").html(htmlStr);
			}
		);
}

//삭제하기
function fdelete(num, name){
	if(confirm("["+name+"]의 게시글을 정말 삭제하시겠습니까?")){
		$.get("gDelete?num="+num,
				function(resp){
					if(resp=="success"){
						alert("삭제성공");
						getData(1,"","");
					}
			}//callback
		)//get
	}//if
}//function