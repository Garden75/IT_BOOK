<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>도서관 조회</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="Webestica.com">
<meta name="description"
	content="Creative Multipurpose Bootstrap Template">

<!-- Favicon -->
<link rel="shortcut icon" href="../assets/images/favicon.ico">

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900%7CPlayfair+Display:400,400i,700,700i%7CRoboto:400,400i,500,700"
	rel="stylesheet">

<!-- Plugins CSS -->
<link rel="stylesheet" type="text/css"
	href="../assets/vendor/font-awesome/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css"
	href="../assets/vendor/themify-icons/css/themify-icons.css" />
<link rel="stylesheet" type="text/css"
	href="../assets/vendor/animate/animate.min.css" />

<!-- Theme CSS -->
<link rel="stylesheet" type="text/css" href="../assets/css/style.css" />
<script type="text/javascript" src ="/js/library.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>

	<header>
		<%@ include file="../include/header.jsp"%>
	</header>



	<div class="innerpage-banner center bg-overlay-dark-7 py-7"
		style="background: url(../assets/images/bg/04.jpg) no-repeat; background-size: cover; background-position: center center;">
		<div class="container">
			<div class="row all-text-white">
				<div class="col-md-12 align-self-center">
					<h1 class="innerpage-title">대전 도서관</h1>
					<h6 class="subtitle"></h6>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item active"><a href="/main?command=loginForm"><i
									class="ti-home"></i>Home</a></li>
							
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<!-- =======================
   Banner innerpage -->
	<section>
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<form name="frm" method="post" action="library?command=libraryReg">
						<input type="hidden" name="command" value="libraryRegister">
						<%-- <input type ="hidden" name = "memNum" value = "${LoginUser.memNum}"> --%>
						<div class="form-group">
							<label>제목</label> <input class="form-control" type="text"
								name="libraryTitle" placeholder="도서관 명을 입력하세요.">
						</div>

						<div class="form-group">
							<label>URL</label> <input class="form-control" type="text"
								name="libraryUrl" placeholder="URL을 입력하세요.">
						</div>

						<div class="form-group">
							<label>도서관 위치</label> <input class="form-control" type="text"
								name="libraryContent" placeholder="위치를 입력하세요.">
						</div>

				
						<button type="submit" class="btn btn-grad border-radius-left-0 mb-0"
						onclick="return libraryCheck()">등록</button>
						<button type="button" class="btn btn-grad border-radius-left-0 mb-0"
						onclick="location.href='library?command=adminLibraryList'">취소</button>
					</form>
				</div>

			</div>

		</div>
	</section>
<script>
$(document).ready(function(){
	$('form').submit(function(){
 	  var result = alert("등록되었습니다.");
   
	   return result;
	})
	})
</script>

	<%@ include file="../include/footer.jsp"%>
</body>
</html>