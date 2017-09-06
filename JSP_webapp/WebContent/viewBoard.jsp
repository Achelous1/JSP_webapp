<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import = "board.model.*" %>
<%@ page import = "java.util.*" %>

<html>
	<head>
		<title>게시판 글 열람</title>
	</head>
	<body>
		<h3>게시판 글 열람</h3>
		<table>
			<tr>
				<td colspan="4" align="right"><a href="boardList.bctrl">[목록으로]</a></td>
			</tr>
			<tr>
				<td>글 제목</td>
				<td colspan="3">${boardRead.title}</p></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="mem_no" maxlength="20" size="20" value="${boardRead.mem_no}" disabled="disabled"></td>
				<td>조회수:${boardRead.read_cnt},</td>
				<td>답글수:${boardRead.child_cnt}</td>
			</tr>
			<tr>
				<td>본문</td>
				<td colspan="3"><textarea name="contents" rows="8" cols="45" disabled="disabled">${boardRead.contents}</textarea></td>
			</tr>
			<tr>
				<td colspan="4" align="right">
					<a href="boardUpdateForm.bctrl?board_no=${boardRead.board_no}">[수정]</a>
					<a href="boardDelete.bctrl?board_no=${boardRead.board_no}">[삭제]</a>
					<a href="boardReplyForm.bctrl?board_no=${boardRead.board_no}">[답글]</a>
				</td>
			</tr>
		</table>
	</body>
</html>