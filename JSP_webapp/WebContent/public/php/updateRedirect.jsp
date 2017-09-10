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
		BoardDTO dto = (BoardDTO)request.getAttribute("boardUpdateForm");
		session.setAttribute("boardUpdateForm", dto);
%>
<script>
	moveTo("Main#!/boardUpdate");
</script>
</body>
</html>