<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int result = (int) request.getAttribute("result");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 삭제</title>
</head>
<body>
	<script type="text/javascript">
	(()=> {
		if(<%=result%> == 1) {
			alert('글이 정상적으로 삭제되었습니다.');
			location.href="/";
			return;
		} else {
			alert('삭제에 실패했습니다. 다시 시도해주세요.');
			location.href="/BoardDetail?i_board=" + <%=result%>;
			return;
		}
	})();
	</script>
</body>
</html>