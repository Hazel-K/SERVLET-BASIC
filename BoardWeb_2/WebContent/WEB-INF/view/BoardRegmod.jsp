<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MODIFY</title>
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
	<div class="err">${msg2}</div>
	<main class="container">
		<form id="write" action="/${vo2 == null? 'BoardWrite' : 'BoardMod'}" method="post" onsubmit="return elechk();">
			<fieldset>
				<legend>글 작성하기</legend>
				<input type="hidden" value="${vo2.i_board}" name="i_board"> <!-- i_board값 가져오는거 잊지말기 -->
				<div class="opt ctnt1">
					<label for="ipt1">제목 </label><input type="text" name="title" id="ipt1" value="${vo2.title}">
				</div>
				<div class="opt ctnt2">
					<label for="ipt2">작성자 </label><input type="text" placeholder="ID_NUMBER로 입력" name="nm" id="ipt2" value="${vo2.i_student}"> <!-- ${vo2 == null ? '':'readOnly'} 로도 제한 가능 -->
				</div>
				<div class="opt ctnt3">
					<label for="ipt3">내용 </label>
					<textarea name="ctnt" id="ipt3" cols="30" rows="10">${vo2.ctnt}</textarea>
				</div>
			</fieldset>
			<div class="btn__wrap">
				<button id="btn1">${vo2 == null ? '등록하기' : '수정하기'}</button>
				<button id="btn2" onclick="goTitle();">돌아가기</button>
			</div>
		</form>
	</main>

	<script>
		(()=>{
			var ipt2 = document.querySelector('#ipt2');
			if (ipt2.value != 0) {
				ipt2.readOnly = true;
				//ipt2.setAttribute("readOnly",true);
			}
		})();
	
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