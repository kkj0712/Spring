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
			    
				//전체보기 내용부분
				var htmlContent="";
				$.each(resp.list,function(key,val){
					htmlContent+="<tr><td>"+val.num+"</a></td>";
					htmlContent+="<td><a href=javascript:fview("+val.num+")>"+val.name+"</a></td>";
					htmlContent+="<td>"+val.grade+"</td>";
					htmlContent+="<td>"+val.content+"</td>";
					htmlContent+="<td>"+val.created+"</td>";
					htmlContent+="<td><a href=javascript:fdelete("+val.num+",'"+val.name+"')>삭제</a></td></tr>";
				})
				$("#listArea tbody").html(htmlContent);
				
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