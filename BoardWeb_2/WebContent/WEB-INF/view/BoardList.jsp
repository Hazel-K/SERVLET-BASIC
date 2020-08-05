<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="blog.naver.hyojin4588.vo.BoardVO" %>
<% 
	List<BoardVO> list = (List)request.getAttribute("data");
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
<title>Insert title here</title>
</head>
<body>
	<main class="container">
        <table>
            <tr>
                <th>No</th>
                <th>제목</th>
                <th>작성자</th>
            </tr>
            <% for(BoardVO vo : list) {%>
            <tr>
                <td><%= vo.getI_board()%></td>
                <td><%= vo.getTitle()%></td>
                <td><%= vo.getI_student()%></td>
            </tr>
            <% }%>
        </table>
    </main>
</body>
</html>