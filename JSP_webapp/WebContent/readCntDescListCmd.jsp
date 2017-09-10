<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
			<tr>
				<td>글 번호</td>
				<td>글 제목</td>
				<td>작성자</td>
				<td>작성일</td>
				
				<td>조회수</td>
				<td>답글수</td>
			</tr>		
			<c:forEach items="${ boardList }" var="dto">
				<tr>
					<td><a href="viewBoard.bctrl?board_no=${dto.board_no }">${dto.board_no }</a></td>
					<td>
						<c:forEach begin="1" end="${dto.lev }">
							<%= "&nbsp;&nbsp;" %>
						</c:forEach>
						<a href="viewBoard.bctrl?board_no=${dto.board_no }">${dto.title }</a></td> 
					<td>${dto.mem_no }</td>
					<td>${dto.post_date }</td>
					
					<td>${dto.read_cnt }</td>
					<td>${dto.child_cnt }</td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>