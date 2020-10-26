$(function(){
	getData(1,"","");
	
	//부트스트랩에서 딸려온 자바스크립트 소스
    $('a.js-scroll-trigger[href*="#"]:not([href="#"])').click(function () {
        if (
            location.pathname.replace(/^\//, "") ==
                this.pathname.replace(/^\//, "") &&
            location.hostname == this.hostname
        ) {
            var target = $(this.hash);
            target = target.length
                ? target
                : $("[name=" + this.hash.slice(1) + "]");
            if (target.length) {
                $("html, body").animate(
                    {
                        scrollTop: target.offset().top,
                    },
                    1000,
                    "easeInOutExpo"
                );
                return false;
            }
        }
    });

    // Closes responsive menu when a scroll trigger link is clicked
    $(".js-scroll-trigger").click(function () {
        $(".navbar-collapse").collapse("hide");
    });

    // Activate scrollspy to add active class to navbar items on scroll
    $("body").scrollspy({
        target: "#sideNav",
    });
	
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
				location.href="#list";
			},
			error: function(e){
				alert("error:"+e)
			}
		})//ajax
	})//submit
	
	//검색하기
	$("#btnSearch").on("click", function(){
		getData(1, $("#field").val(), $("#word").val());
	})//btnSearch
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
				htmlTitle+="<th>No.</th>";
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
				
				//상세보기 부분 clear
				$("#viewArea").html("");
		} //callback
	) //get
} //function

//상세보기
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

//삭제하기
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