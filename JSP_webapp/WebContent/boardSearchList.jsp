<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>게시판 검색 결과 조회</title>
	</head>
	<body>
		<h3>게시판 검색 결과 조회</h3>
		
		<table border="1">
			<tr>
				<td colspan="7" align="right">
					<a href="boardWriteForm.bctrl">[새글쓰기]</a>
				</td>
			</tr>
			<tr>
				<td>글 번호</td>
				<td>글 제목</td>
				<td>작성자</td>
				<td>작성일</td>
				<td>작성시간</td>
				<td>조회수</td>
				<td>답글수</td>
			</tr>		
			<c:forEach items="${boardList }" var="dto">
				<tr>
					<td><a href="ViewBoard.bctrl?board_no=${dto.board_no }">${dto.board_no }</a></td>
					
					<td>
						<c:forEach begin="1" end="${dto.lev }">
							<%= "&nbsp;&nbsp;" %>
						</c:forEach>
						<a href="boardRead.bctrl?board_no=${dto.board_no }">${dto.title }</a></td>
					<td>${dto.mem_no }</td>
					<td>${dto.post_date }</td>
					<td></td>
					<td>${dto.read_cnt }</td>
					<td>${dto.child_cnt }</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="7" align="center">
					<a href="boardList.bctrl">[첫 페이지로]</a>
				</td>
			</tr>
		</table>
	</body>
</html>