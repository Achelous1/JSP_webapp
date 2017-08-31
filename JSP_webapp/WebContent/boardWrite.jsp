<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>게시판 새글 쓰기</title>
</head>
<body>
	<h3>게시판 새글</h3>
	<form action="boardWrite.bctrl" method="post">
	<table>
		<tr>
			<td colspan="4" align="right"><a href="boardList.bbs">[목록으로]</a>
			</td>
		</tr>
		<tr>
			<td>글제목</td>
			<td colspan="3"><input type="text" name="title" maxlength="50"></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td colspan="3"><input type="text" name="mem_no" maxlength="4"></td>
		</tr>
		<tr>
			<td>본문</td>
			<td colspan="3"><textarea name="contents" rows="8" cols="45"></textarea></td>
		</tr>
		<tr>
			<td colspan="4" align="right">
				<input type="submit" value="글올리기"></a>
			</td>
		</tr>
	</table></form>	
</body>
</html>