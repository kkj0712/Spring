<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
<h2>개인 정보 수정</h2>
<form action="update.go" method="post">
<input type="hidden" name="id" value="${user.id}">
이름: <input type="text" name="name" value="${user.name}"><br>
아이디: ${user.id}<br>
패스워드 : <input type="password" name="password" value="${user.password}"><br>
성별: 
 <label for="man">  남</label> 
 <input type="radio" name="gender" id="man"  value="남">
  여 <input type="radio" name="gender" value="여"><br>
직업:
<select name="job" id="job">
  <option value="회사원">회사원
  <option value="학생">학생
  <option value="기타">기타
</select>
<script>
//성별
if("${user.gender}"=="남"){
	$("input:radio[value='남']").prop("checked", true);
}else{
	$("input:radio[value='여']").prop("checked", true);
}
//직업
$("#job option").each(function(){
	if($(this).val()=="${user.job}"){
		$(this).prop("selected", true);
	}
})
</script>
<br><br>
<input type="submit" value="확인">
<input type="reset"  value="취소">
</form>
</body>
</html>