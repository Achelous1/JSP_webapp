<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>게시판 글 수정</title>
	</head>
	<body>
		<h3>게시판 글 수정</h3>
		<form action="boardUpdate.bctrl" method="post">
			<table>
				<tr>
					<td colspan="4" align="right">
					<input type="hidden" name="board_no" value="${boardUpdateForm.board_no}"><a href="boardList.bctrl">[목록으로]</a></td>
				</tr>
				<tr>
					<td>글 제목</td>
					<td colspan="3"><input type="text" name="title" value="${boardUpdateForm.title}"></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="mem_no" value="${boardUpdateForm.mem_no}" ></td>
					<td></td>
					<td></td>				
				</tr>
				<tr>
					<td>본문</td>
					<td colspan="3"><textarea name="contents">${boardUpdateForm.contents}</textarea></td>
				</tr>
				<tr>
					<td colspan="4" align="right">
						<input type="submit" value="수정완료">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>