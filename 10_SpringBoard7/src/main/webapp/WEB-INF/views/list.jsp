<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/resources/include.jsp" %>
<body>
<div class="container">
  <h3>작성 리스트</h3>  
 <div id="resultCount"><p>게시글수:${count } </p></div>   
  <table class="table table-striped">
    <thead>
      <tr>
        <th>NO(seq)</th>
        <th>작성자</th>
        <th>제목</th>
        <th>내용</th>
        <th>작성일</th>
        <th>조회수</th>
        <th>삭제</th>
      </tr>
    </thead>
    <tbody>
     <c:forEach items="${list }" var="list">    
      <tr>
        <td>${list.num }</td>
        <td><a href="view?num=${list.num}">${list.writer }</a></td>
        <td>${list.title }[<c:out value="${list.replycnt}"/>]</td>
        <td>${list.content }</td>
        <td>${list.regdate }</td>
        <td>${list.hitcount }</td>
        <td><a href="boardDelete?num=${list.num}">삭제</a></td>
      </tr>
     </c:forEach> 
    </tbody>
  </table>
  
  <!-- 페이징 -->
  <div align="center" id="pageArea">
  	${pageHtml }
  </div>
   
  <!-- 검색 -->
  <div align="left">
	<form name ="search" id="search">
		<select name="field" id="field">
			<option value="writer">작성자</option>
			<option value="content">내용</option>
		</select>
		<input type="text" name="word" id="word">
		<input type="button" value="찾기" id="btnSearch" class="btn btn-default">
	</form>
  </div>
  
  <c:if test="${sessionScope.sessionDto!=null }">
  	<a href="/board7/boardInsert">글쓰기</a>
  </c:if>
 
</div>

<script>
	function getData(pageNum, field, word){
		$.get("searchList",
				{"pageNum":pageNum, "field":field, "word":word},
				function(resp){
					//alert(resp.list);
					var countStr = "<p>게시글 수: "+resp.count+"</p>";
					$("#resultCount").html(countStr);

					var htmlStr = "";
					$.each(resp.list, function(key, val){
						htmlStr+="<tr>";
						htmlStr+="<td>"+val.num+"</td>";
						htmlStr+="<td><a href='view?num="+val.num+"'>"+val.writer+"</a></td>";
						htmlStr+="<td>"+val.title+"</td>";
						htmlStr+="<td>"+val.content+"</td>";
						htmlStr+="<td>"+val.regdate +"</td>";
						htmlStr+="<td>"+val.hitcount +"</td>";
						htmlStr+="<td><a href='boardDelete?num="+val.num+"'>삭제</a></td>";
					});
					$("table tbody").html(htmlStr);
					
					var pageStr="<div align='center'>"+resp.pageHtml+"</div>";
					$("#pageArea").html(pageStr);
						
					
				}//get function
		)//get
	}//function

	$("#btnSearch").click(function(){
		getData("1",$("#field").val(),$("#word").val());	

	});
	
</script>
</body>
</html>