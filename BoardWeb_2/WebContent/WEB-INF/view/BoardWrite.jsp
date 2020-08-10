<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write</title>
<style>
.container {
	width: 700px;
	margin: 20px auto;
}

legend {
	font-size: 20px;
	font-weight: 800;
}

fieldset {
	display: flex;
}

.opt:not(:last-child) {
	margin: 20px 20px 30px 20px;
	display: flex;
	justify-content: space-between;
}

.opt:last-child {
	display: flex;
	flex-direction: column;
	justify-content: space-between;
	margin: 20px 20px 10px 20px;
}

.ctnt3>label {
	margin-bottom: 10px;
}

input {
	width: 85%;
}

.btn__wrap {
	margin-top: 20px;
	display: flex;
	justify-content: flex-end;
}

.btn__wrap button:last-child {
	margin-left: 10px;
}

textarea {
	font-size: 18px;
	resize: none;
}
</style>
</head>

<body>
	<main class="container">
		<form id="write" action="/BoardWriteProc" method="post" onsubmit="return elechk();">
			<fieldset>
				<legend>글 작성하기</legend>
				<div class="opt ctnt1">
					<label for="ipt1">제목 </label><input type="text" name="title" id="ipt1">
				</div>
				<div class="opt ctnt2">
					<label for="ipt2">작성자 </label><input type="text" name="nm" id="ipt2">
				</div>
				<div class="opt ctnt3">
					<label for="ipt3">내용 </label>
					<textarea name="ctnt" id="ipt3" cols="30" rows="10"></textarea>
				</div>
			</fieldset>
			<div class="btn__wrap">
				<button id="btn1">글등록</button>
				<button id="btn2" onclick="goTitle();">돌아가기</button>
			</div>
		</form>
	</main>

	<script>
		function elechk() {
			if (eleValid(write.title, '제목')) {
				return false;
			} else if (eleValid(write.nm, '작성자')) {
				return false;
			} else if (eleValid(write.ctnt, '내용')) {
				return false;
			}
		}

		function eleValid(element, name) {
			if (element.value.length == 0) {
				alert(name + '을 입력해주세요.');
				element.focus();
				return true;
			}
		}

		function goTitle() {
			event.preventDefault();
			location.href = "/";
		}
	</script>
</body>
</html>