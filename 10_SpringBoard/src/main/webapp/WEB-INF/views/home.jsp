<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>SpringBoard</title>
        <link rel="icon" type="image/x-icon" href="/board/resources/assets/img/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.13.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Saira+Extra+Condensed:500,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Muli:400,400i,800,800i" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="/board/resources/css/styles.css" rel="stylesheet" />
</head>
<body id="page-top">
<!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
            <a class="navbar-brand js-scroll-trigger" href="#page-top">
                <span class="d-block d-lg-none">SpringBoard</span>
                <span class="d-none d-lg-block"><img class="img-fluid img-profile rounded-circle mx-auto mb-2" src="/board/resources/assets/img/profile.jpg" alt="" /></span>
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#insert">추가</a></li>
                    <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#list">리스트</a></li>
                </ul>
            </div>
        </nav>
<!-- Page Content-->
        <div class="container-fluid p-0">
                    
        <!-- Bootstrap core JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js"></script>
        <!-- Third party plugin JS-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
        <!-- Core theme JS-->
		<script src="/board/resources/js/board.js"></script>
        
<!-- 추가하기-->
            <section class="resume-section" id="insert">
                <div class="resume-section-content">
                    <h2 class="mb-0">
                        추가하기
                        <span class="text-primary">Spring Board</span>
                    </h2>
<!-- 입력 폼 넣기 -->
						<form action="boardInsert" method="post">
						      <label for="writer">글쓴이</label>
						      	<input type="text" size="20" id="writer" name="writer" class="form-control">
						      <label for="title">제목</label>
						      	<input type="text" size="37" id="title" name="title" class="form-control">
						      <label for="content">내용</label>
						      	<textarea rows="5" cols="40" id="content" name="content" class="form-control"></textarea>
						      <label for="password">비밀번호</label>
						      	<input type="password" size="20" id="password" name="password" class="form-control">
					    	<div align="center" style="margin-top: 20px">
					    		<input type="button" id="submit" name="submit" value="입력" class="btn btn-sm btn-primary">
					    		<input type="reset" value="취소" class="btn btn-sm btn-secondary">
					    	</div>
						</form>
<!-- 입력 폼 끝 -->
                </div>
            </section>
<!-- 추가하기 끝 -->
            <hr class="m-0" />
<!-- 리스트-->
            <section class="resume-section" id="list">
                <div class="resume-section-content">
                    <h2 class="mb-5">리스트
                    	<span class="text-primary"><a href="javascript:getData(1,'','')">BoardList</a></span>
                    </h2>
                    <div class="d-flex flex-column flex-md-row justify-content-between mb-5">
                        <div class="flex-grow-1">
                           	<!-- 갯수 출력 count-->
                        		<div class="flex-shrink-0" ><span class="text-primary" id="countArea"></span></div>
							<!-- 전체보기 결과값 data(list)-->
								<div id="listArea" align="center" class="container">
									<table class="table table-hover">
										<thead></thead>
										<tbody></tbody>
									</table>
								</div>
							<!-- 상세보기 view -->
								<div id="viewArea" align="center"></div>
								
							<!-- 페이징 영역 paging-->
								<div id="pageArea" align="center"></div>
							<!-- 검색 영역 -->
								<div align="center">
									<form name="search" id="search" >
										<select name="field" id="field" >
											<option value="writer">글쓴이</option>
											<option value="title">제목</option>
										</select>
										<input type="text" name="word" id="word">
										<input type = "button" value = "검색" id = "btnSearch" class="btn btn-sm btn-primary"> 
									</form>
								</div> 
							<!-- 검색 영역 끝-->
                        </div>
                    </div>
                </div>
            </section>
<!-- 리스트 끝 -->

</div>   
</body>
</html>