<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="blog.naver.hyojin4588.vo.BoardVO"%>
<%
	List<BoardVO> list = (List) request.getAttribute("data");
%>
<!-- JSP의 중요한 네가지 class의 Lifecicle -->
<!-- pageContext는 페이지를 끄는 순간 죽음 개인, 호출 당 하나 -->
<!-- request는 호출을 하고난 후 죽음 개인, 호출 당 하나 -->
<!-- session은 브라우저를 끄는 순간 죽음 개인, 브러우저 당 하나 -->
<!-- application은 서버를 끄는 순간 죽음 전체, 서버 당 하나 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
<style>
.container {
	width: 700px;
	margin: 0 auto;
	position: relative;
}

caption {
	font-size: 30px;
	font-weight: 900;
	margin-bottom: 10px;
}

table {
	border-collapse: collapse;
	width: inherit;
	margin-bottom: 20px;
}

th {
	background-color: pink;
}

td {
	text-align: center;
}

th, td {
	border: 1px solid black;
	font-size: 20px;
	padding: 10px 0;
}

tr:nth-child(odd) {
	background-color: whitesmoke;
}

tr:nth-child(even) {
	background-color: silver;
}

.list_content:hover {
	background-color: wheat;
	cursor: pointer;
	transition: 1s ease;
}

#btn1 {
	position: absolute;
	right: 0;
}
</style>
</head>
<body>
	<main class="container">
		<table>
			<caption>게시판 리스트</caption>
			<colgroup>
				<col>
				<col>
				<col>
			</colgroup>
			<tr>
				<th>No</th>
				<th>제목</th>
				<th>작성자</th>
			</tr>
			<%
				for (BoardVO vo : list) {
			%>
			<tr class="list_content"
				onclick="moveToDetail(<%=vo.getI_board()%>)">
				<td><%=vo.getI_board()%></td>
				<td><%=vo.getTitle()%></td>
				<td><%=vo.getNm()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<button id="btn1" onclick="goWrite();">글쓰기</button>
	</main>
	<script>
        function moveToDetail(i_board) {
            location.href='/BoardDetail?i_board=' + i_board;
        }
        function goWrite() {
        	location.href="/BoardWrite";
        }
    </script>
</body>
</html>