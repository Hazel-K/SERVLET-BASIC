<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% int temp = (int)request.getAttribute("temp"); %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>글 등록</title>
</head>
<body>
    <script type="text/javascript">
    	function init () {
    		if (<%=temp%> == 1) {
    			alert('글이 정상적으로 등록되었습니다.');
    			location.href="/";
    		} else {
    			alert('글 등록에 실패했습니다. 다시 시도해주세요');
    			location.href="/BoardWrite";
    		}
    	}
    	
    	init();
    </script>
</body>
</html>