<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "board.model.BoardDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="./public/js/script.js"></script>
<title>Redirecting</title>
</head>
<body>
	<%
		BoardDTO content = (BoardDTO)request.getAttribute("boardRead");
    	session.setAttribute("content", content);
	%>
	페이지 리다이렉트
<script>
	moveTo("index.jsp#!/viewBoard");
</script>
</body>
</html>