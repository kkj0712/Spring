$(function(){
	getData(1, "", "");
});

function getData(pageNum, field, word){
	$.get("gList", {"pageNum":pageNum, "field":field, "word":word}, 
			function(resp){
				$("#countArea").html("평가리스트 개수: ("+resp.count+")");
				$("#listArea").html(resp.list.length);
		} //callback
	) //get
} //function