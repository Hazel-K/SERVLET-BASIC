<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="blog.naver.hyojin4588.vo.BoardVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
<style>
.container {
	width: 700px;
	margin: 20px auto;
	display: flex;
	flex-direction: column;
	align-items: flex-start;
	padding-left: 10px;
}

.title__wrap {
	width: inherit;
	display: flex;
	justify-content: flex-start;
	margin: 20px 0px;
}

.title__ctnt {
	font-size: 2em;
	font-weight: 800;
}

.auth__wrap {
	width: inherit;
	display: flex;
	justify-content: flex-end;
	margin-bottom: 20px;
}

.btn__wrap {
	width: inherit;
	display: flex;
	justify-content: flex-end;
}

.btn__wrap {
	margin-top: 20px;
}

.btn2, .auth__ctnt {
	margin-left: 10px;
}
</style>
</head>
<body>
	<main class="container">
		<header class="title__wrap wrapper">
			<div class="title__title"></div>
			<div class="title__ctnt">${data.title}</div>
		</header>
		<section class="auth__wrap wrapper">
			<div class="auth__title">작성자 :</div>
			<div class="auth__ctnt">${data.i_student}</div>
		</section>
		<section class="ctnt__wrap wrapper">
			<div class="ctnt__title"></div>
			<div class="ctnt__ctnt">${data.ctnt}</div>
		</section>
		<footer class="btn__wrap wrapper">
			<button class="btn1">수정</button>
			<button class="btn2" onclick="goTitle();">리스트로</button>
		</footer>
	</main>
	<script>
		function goTitle() {
			location.href = "/";
		}
	</script>
</body>
</html>