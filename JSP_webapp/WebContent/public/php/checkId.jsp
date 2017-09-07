<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Check availability</title>
</head>
<body>
	<div style="height: 20%; width: 100%; color: white; background-color: rgb(255, 88, 117); text-align: center;">
		<h3>아이디 중복 확인</h3>
		<hr style="border: 3px solid rgb(255, 192, 203); margin-top: -10px;">
	</div>
	<div style="text-align:center;">
	<%
		String user_id = request.getParameter("user_id");
		if(request.getAttribute("isAvailable").equals(true)){
			session.setAttribute("checkedId", true);
	%>
		<p style="margin-top: 30px;">[<%= user_id %>]</p>
		<p style="margin-top: 30px; margin-bottom: 30px;">이 아이디는 사용할 수 있습니다</p>
	<%
		} else{
			session.setAttribute("checkedId", false);
	%>
		<p style="margin-top: 30px;">[<%= user_id %>]</p>
		<p style="margin-bottom: 30px;">이 아이디는 사용할 수 없습니다</p>
	<%
		}
	%>
		<a class="btn btn-default" onclick="closeWin();">창닫기</a>
	</div>
	<script>
	function closeWin(){
		 window.close();
	}
	</script>
</body>
</html>